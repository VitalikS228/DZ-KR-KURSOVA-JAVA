package com.sewaggg.views;

import com.sewaggg.models.Hotel;
import com.sewaggg.models.Transport;
import com.sewaggg.models.User;
import com.sewaggg.utils.HotelManager;
import com.sewaggg.utils.TransportManager;
import com.sewaggg.utils.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

/**
 * Клас `ClientHandler` відповідає за керування взаємодією з клієнтом в системі бронювання.
 * Він обробляє аутентифікацію користувача, реєстрацію та різні операції щодо бронювання як для адміністраторів, так і для клієнтів.
 */
public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final BufferedReader reader;
    private final PrintWriter writer;
    private final UserManager userManager;
    private final TransportManager transportManager;
    private final HotelManager hotelManager;
    private User currentUser;

    /**
     * Конструктор для створення нового екземпляра класу `ClientHandler`.
     *
     * @param clientSocket    Сокет, що представляє з'єднання клієнта.
     * @param userManager     Екземпляр класу `UserManager`, відповідального за управління операціями, пов'язаними з користувачами.
     * @param transportManager Екземпляр класу `TransportManager`, відповідального за управління операціями, пов'язаними з транспортом.
     * @param hotelManager     Екземпляр класу `HotelManager`, відповідального за управління операціями, пов'язаними з готелями.
     * @throws IOException    Якщо сталася помилка вводу/виводу під час створення BufferedReader або PrintWriter.
     */
    public ClientHandler(Socket clientSocket, UserManager userManager, TransportManager transportManager, HotelManager hotelManager) throws IOException {
        System.out.println("client constructor");
        this.clientSocket = clientSocket;
        this.userManager = userManager;
        this.transportManager = transportManager;
        this.hotelManager = hotelManager;
        this.reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.writer = new PrintWriter(clientSocket.getOutputStream(), true);
    }
    /**
     * Запускає `ClientHandler` як окремий потік, обробляючи взаємодію з клієнтом.
     * Викликає метод `handleClient` та закриває сокет клієнта після завершення обробки.
     */
    @Override
    public void run() {
        System.out.println("RUN FROM CLIENT");
        try {
            handleClient();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Обробляє основну взаємодію з клієнтом, пропонуючи користувачеві увійти або зареєструватися
     * та управляючи діями користувача на основі їх виборів.
     *
     * @throws IOException Якщо сталася помилка вводу/виводу під час читання введення від клієнта.
     */
    private void handleClient() throws IOException {
        writer.println("Вас вітає система бронювання. Будь ласка, увійдіть або зареєструйтеся.");

        while (true) {
            writer.println("Оберіть опцію:");
            writer.println("1. Увійти");
            writer.println("2. Зареєструватися");
            writer.println("3. Вийти");

            String choice = reader.readLine();

            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    System.out.println("Допобачення!");
                    writer.println("exit");
                    return;
                default:
                    writer.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
    /**
     * Обробляє процес входу користувача, аутентифікуючи користувача та надаючи доступ до системи в разі успіху.
     *
     * @throws IOException Якщо сталася помилка вводу/виводу під час читання введення від клієнта.
     */
    private void login() throws IOException {
        writer.println("Введіть логін:");
        String username = reader.readLine();
        writer.println("Введіть пароль:");
        String password = reader.readLine();

        currentUser = userManager.authenticateUser(username, password);

        if (currentUser != null) {
            writer.println("Ви успішно увійшли в систему, " + currentUser.getUsername() + "!");
            handleUserActions();
        } else {
            writer.println("Неправильний логін або пароль. Спробуйте ще раз.");
        }
    }
    /**
     * Обробляє процес реєстрації користувача, створюючи нового користувача та додаючи його до системи.
     *
     * @throws IOException Якщо сталася помилка вводу/виводу під час читання введення від клієнта.
     */
    private void register() throws IOException {
        writer.println("Введіть логін для реєстрації:");
        String username = reader.readLine();
        writer.println("Введіть пароль для реєстрації:");
        String password = reader.readLine();
        writer.println("Виберіть роль (admin або client):");
        String role = reader.readLine();

        User newUser = new User(username, password, role);
        userManager.addUser(username, newUser);
        writer.println("Ви успішно зареєструвалися в системі, " + username + "!");
        currentUser = newUser;
        handleUserActions();
    }
    /**
     * Маршрутує користувачів до відповідного набору дій на основі їх ролей (admin або client).
     *
     * @throws IOException Якщо сталася помилка вводу/виводу під час читання введення від клієнта.
     */
    private void handleUserActions() throws IOException {
        while (true) {
            if (currentUser.getRole().equals("admin")) {
                handleAdminActions();
            } else if (currentUser.getRole().equals("client")) {
                handleClientActions();
            }
        }
    }
    /**
     * Керує діями, доступними адміністраторам, такими як додавання транспорту чи готелів та перегляд пов'язаної інформації.
     *
     * @throws IOException Якщо сталася помилка вводу/виводу під час читання введення від клієнта.
     */
    private void handleAdminActions() throws IOException {
        writer.println("Оберіть дію (роль адміністратора):");
        writer.println("1. Додати транспорт");
        writer.println("2. Додати готель");
        writer.println("3. Переглянути інформацію про транспорт");
        writer.println("4. Переглянути інформацію про готелі");
        writer.println("5. Вийти");

        String choice = reader.readLine();

        switch (choice) {
            case "1":
                addTransport();
                break;
            case "2":
                addHotel();
                break;
            case "3":
                showAvailableTransport();
                break;
            case "4":
                showAvailableHotels();
                break;
            case "5":
                handleClient();
                break;
            default:
                writer.println("Невірний вибір. Спробуйте ще раз.");
        }
    }
    /**
     * Керує діями, доступними клієнтам, такими як перегляд доступного транспорту чи готелів,
     * бронювання квитків, та скасування бронювань.
     *
     * @throws IOException Якщо сталася помилка вводу/виводу під час читання введення від клієнта.
     */
    private void handleClientActions() throws IOException {
        writer.println("Оберіть дію (роль клієнта):");
        writer.println("1. Переглянути доступний транспорт");
        writer.println("2. Переглянути доступні готелі");
        writer.println("3. Забронювати квиток на транспорт");
        writer.println("4. Забронювати номер в готелі");
        writer.println("5. Відмінити бронювання");
        writer.println("6. Вийти");

        String choice = reader.readLine();

        switch (choice) {
            case "1":
                showAvailableTransport();
                break;
            case "2":
                showAvailableHotels();
                break;
            case "3":
                bookTransportTicket();
                break;
            case "4":
                bookHotelRoom();
                break;
            case "5":
                cancelBooking();
                break;
            case "6":
                handleClient();
            default:
                writer.println("Невірний вибір. Спробуйте ще раз.");
        }
    }
    /**
     * Додає новий транспорт до системи, запитуючи адміністратора про інформацію, таку як маршрут, тип, ціна та загальна кількість місць.
     *
     * @throws IOException Якщо сталася помилка вводу/виводу під час читання введення від клієнта.
     */
    private void addTransport() throws IOException {
        writer.println("Введіть маршрут нового транспорту:");
        String route = reader.readLine();
        writer.println("Введіть тип транспорту:");
        String type = reader.readLine();
        writer.println("Введіть вартість квитка:");
        double price = Double.parseDouble(reader.readLine());
        writer.println("Введіть кількість місць у транспорті:");
        int totalSeats = Integer.parseInt(reader.readLine());

        Transport newTransport = new Transport(route, type, price, totalSeats);
        transportManager.addTransport(route, newTransport);
        writer.println("Транспорт для маршруту " + route + " успішно доданий до системи.");
    }
    /**
     * Додає новий готель до системи, запитуючи адміністратора про інформацію, таку як назва, адреса, ціна та загальна кількість номерів.
     *
     * @throws IOException Якщо сталася помилка вводу/виводу під час читання введення від клієнта.
     */
    private void addHotel() throws IOException {
        writer.println("Введіть назву нового готелю:");
        String hotelName = reader.readLine();
        writer.println("Введіть адресу готелю:");
        String address = reader.readLine();
        writer.println("Введіть вартість номера в готелі:");
        double price = Double.parseDouble(reader.readLine());
        writer.println("Введіть кількість номерів у готелі:");
        int totalRooms = Integer.parseInt(reader.readLine());

        Hotel newHotel = new Hotel(hotelName, address, price, totalRooms);
        hotelManager.addHotel(hotelName, newHotel);
        writer.println("Готель " + hotelName + " успішно доданий до системи.");
    }

    /**
     * Показує доступний транспорт клієнту.
     * Виводить інформацію про маршрути, тип, вартість та доступні місця для кожного транспортного засобу.
     */
    private void showAvailableTransport() {
        Map<String, Transport> availableTransport = transportManager.getAvailableTransport();
        if (availableTransport.isEmpty()) {
            writer.println("На даний момент немає доступного транспорту.");
        } else {
            writer.println("Доступний транспорт:");
            for (Map.Entry<String, Transport> entry : availableTransport.entrySet()) {
                writer.println("Маршрут: " + entry.getKey() +
                        ", Тип: " + entry.getValue().getType() +
                        ", Вартість: " + entry.getValue().getPrice() +
                        ", Вільні місця: " + entry.getValue().getAvailableSeats());
            }
        }
    }
    /**
     * Показує доступні готелі клієнту.
     * Виводить інформацію про назву, адресу, вартість номера та доступні номери для кожного готелю.
     */
    private void showAvailableHotels() {
        Map<String, Hotel> availableHotels = hotelManager.getAvailableHotels();
        if (availableHotels.isEmpty()) {
            writer.println("На даний момент немає доступних готелів.");
        } else {
            writer.println("Доступні готелі:");
            for (Map.Entry<String, Hotel> entry : availableHotels.entrySet()) {
                writer.println("Назва: " + entry.getKey() +
                        ", Адреса: " + entry.getValue().getAddress() +
                        ", Вартість номера: " + entry.getValue().getPrice() +
                        ", Вільні номери: " + entry.getValue().getAvailableRooms());
            }
        }
    }
    /**
     * Бронює квиток на транспорт для клієнта.
     * Клієнт обирає маршрут, на який він хоче забронювати квиток.
     * Після успішного бронювання, оновлюється інформація про доступний транспорт та зберігається інформація у файли.
     *
     * @throws IOException Виникає, якщо виникають проблеми з читанням введених даних.
     */
    private void bookTransportTicket() throws IOException {
        showAvailableTransport();

        writer.println("Введіть маршрут, на який ви хочете забронювати квиток:");
        String route = reader.readLine();

        if (transportManager.getAvailableTransport().containsKey(route)) {
            Transport selectedTransport = transportManager.getAvailableTransport().get(route);

            if (selectedTransport.getAvailableSeats() > 0) {
                selectedTransport.bookSeat();
                currentUser.addPurchasedTicket(route);
                writer.println("Квиток на маршрут " + route + " успішно заброньовано!");
            } else {
                writer.println("Вибачте, всі місця на цьому транспорті вже заброньовані.");
            }
        } else {
            writer.println("Маршрут " + route + " не знайдено. Спробуйте ще раз.");
        }
        userManager.saveToFile();
        transportManager.saveToFile();
        hotelManager.saveToFile();
    }
    /**
     * Бронює номер в готелі для клієнта.
     * Клієнт обирає назву готелю, в якому він хоче забронювати номер.
     * Після успішного бронювання, оновлюється інформація про доступні готелі та зберігається інформація у файли.
     *
     * @throws IOException Виникає, якщо виникають проблеми з читанням введених даних.
     */
    private void bookHotelRoom() throws IOException {
        showAvailableHotels();

        writer.println("Введіть назву готелю, в якому ви хочете забронювати номер:");
        String hotelName = reader.readLine();

        if (hotelManager.getAvailableHotels().containsKey(hotelName)) {
            Hotel selectedHotel = hotelManager.getAvailableHotels().get(hotelName);

            if (selectedHotel.getAvailableRooms() > 0) {
                selectedHotel.bookRoom();
                currentUser.addBookedRoom(hotelName);
                writer.println("Номер в готелі " + hotelName + " успішно заброньовано!");
            } else {
                writer.println("Всі номери у цьому готелі вже заброньовані.");
            }
        } else {
            writer.println("Готель " + hotelName + " не знайдено. Спробуйте ще раз.");
        }

        userManager.saveToFile();
        transportManager.saveToFile();
        hotelManager.saveToFile();

    }
    /**
     * Відміняє бронювання для клієнта.
     * Клієнт може вибрати опцію відміни бронювання квитка на транспорт чи номера в готелі.
     * Після успішної відміни, оновлюється інформація про доступні транспорт та готелі та зберігається інформація у файли.
     *
     * @throws IOException Виникає, якщо виникають проблеми з читанням введених даних.
     */
    private void cancelBooking() throws IOException {
        writer.println("Виберіть опцію для відміни бронювання:");
        writer.println("1. Відмінити квиток на транспорт");
        writer.println("2. Відмінити бронювання номера в готелі");
        writer.println("3. Назад");

        String choice = reader.readLine();

        switch (choice) {
            case "1":
                cancelTransportBooking();
                break;
            case "2":
                cancelHotelBooking();
                break;
            case "3":
                return;
            default:
                writer.println("Невірний вибір. Спробуйте ще раз.");
        }

        userManager.saveToFile();
        transportManager.saveToFile();
        hotelManager.saveToFile();

    }
    /**
     * Відміняє бронювання квитка на транспорт для клієнта.
     * Клієнт вводить маршрут квитка, який він хоче скасувати.
     * Після успішної відміни, оновлюється інформація про доступний транспорт та зберігається інформація у файли.
     *
     * @throws IOException Виникає, якщо виникають проблеми з читанням введених даних.
     */
    private void cancelTransportBooking() throws IOException {
        writer.println("Введіть маршрут квитка, який ви хочете скасувати:");
        String route = reader.readLine();

        if (currentUser.cancelTicket(route)) {
            Transport selectedTransport = transportManager.getAvailableTransport().get(route);
            selectedTransport.cancelSeat(); // Відмінити бронювання місця
            writer.println("Бронювання квитка на маршрут " + route + " скасовано.");
        } else {
            writer.println("Квиток на маршрут " + route + " не знайдено або вже скасовано.");
        }
    }
    /**
     * Відміняє бронювання номера в готелі для клієнта.
     * Клієнт вводить назву готелю та номер, який він хоче скасувати.
     * Після успішної відміни, оновлюється інформація про доступні готелі та зберігається інформація у файли.
     *
     * @throws IOException Виникає, якщо виникають проблеми з читанням введених даних.
     */
    private void cancelHotelBooking() throws IOException {
        writer.println("Введіть назву готелю, номер якого ви хочете скасувати:");
        String hotelName = reader.readLine();

        if (currentUser.cancelBookedRoom(hotelName)) {
            Hotel selectedHotel = hotelManager.getAvailableHotels().get(hotelName);
            selectedHotel.cancelRoom(); // Відмінити бронювання номера
            writer.println("Бронювання номера в готелі " + hotelName + " скасовано.");
        } else {
            writer.println("Бронювання номера в готелі " + hotelName + " не знайдено або вже скасовано.");
        }
    }
}

