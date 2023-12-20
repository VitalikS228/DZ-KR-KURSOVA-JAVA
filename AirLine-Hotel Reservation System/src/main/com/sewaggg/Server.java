package com.sewaggg;

import com.sewaggg.utils.TransportManager;
import com.sewaggg.utils.HotelManager;
import com.sewaggg.utils.UserManager;
import com.sewaggg.views.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Клас Server відповідає за запуск серверної частини програми та обробку з'єднань з клієнтами.
 */
public class Server {
    private static final int PORT = 12345;

    /**
     * Точка входу у програму для серверної частини.
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /**
     * Метод start ініціалізує та запускає серверну частину програми.
     */
    private void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущено на порту " + PORT);

            // Ініціалізація менеджерів для користувачів, транспорту та готелів
            UserManager userManager = new UserManager();
            TransportManager transportManager = new TransportManager();
            HotelManager hotelManager = new HotelManager();

            // Завантаження даних з файлів
            userManager.loadFromFile();
            hotelManager.loadFromFile();
            transportManager.loadFromFile();

            boolean serverRunning = true;

            // Обробка з'єднань з клієнтами
            while (serverRunning) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("З'єднання встановлено з " + clientSocket.getInetAddress());

                    // Створення обробників для клієнтів
                    ClientHandler clientHandler = new ClientHandler(clientSocket, userManager, transportManager, hotelManager);
                    Thread clientThread = new Thread(clientHandler);
                    clientThread.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}