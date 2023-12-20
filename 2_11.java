import java.util.ArrayList;

// Клас Bus
class Bus {
    private String driverName;
    private String busNumber;
    private int routeNumber;
    private String make;
    private int year;
    private int mileage;

    // Конструктор
    public Bus(String driverName, String busNumber, int routeNumber, String make, int year, int mileage) {
        this.driverName = driverName;
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
    }

    // Метод для отримання прізвища та ініціалів водія
    public String getDriverName() {
        return driverName;
    }

    // Метод для отримання номера автобуса
    public String getBusNumber() {
        return busNumber;
    }

    // Метод для отримання номера маршруту
    public int getRouteNumber() {
        return routeNumber;
    }

    // Метод для отримання марки автобуса
    public String getMake() {
        return make;
    }

    // Метод для отримання року початку експлуатації
    public int getYear() {
        return year;
    }

    // Метод для отримання пробігу
    public int getMileage() {
        return mileage;
    }

    // Перевизначений метод toString для зручного виводу об'єкта у вигляді рядка
    @Override
    public String toString() {
        return "Bus{" +
                "driverName='" + driverName + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", routeNumber=" + routeNumber +
                ", make='" + make + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                '}';
    }
}

// Клас BusManager
class BusManager {
    private ArrayList<Bus> buses;

    // Конструктор
    public BusManager() {
        buses = new ArrayList<>();
    }

    // Метод для додавання автобуса
    public void addBus(Bus bus) {
        buses.add(bus);
    }

    // Метод для отримання списку автобусів для заданого маршруту
    public ArrayList<Bus> getBusesForRoute(int routeNumber) {
        ArrayList<Bus> result = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getRouteNumber() == routeNumber) {
                result.add(bus);
            }
        }
        return result;
    }

    // Метод для отримання списку автобусів для заданого номера маршруту
    public ArrayList<Bus> getBusesByNumber(String busNumber) {
        ArrayList<Bus> result = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber)) {
                result.add(bus);
            }
        }
        return result;
    }

    // Метод для отримання списку автобусів пробіг у яких більше заданої відстані
    public ArrayList<Bus> getBusesWithMileageGreaterThan(int mileage) {
        ArrayList<Bus> result = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getMileage() > mileage) {
                result.add(bus);
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів автобусів
        Bus bus1 = new Bus("John Doe", "ABC123", 101, "Mercedes", 2020, 5000);
        Bus bus2 = new Bus("Jane Smith", "DEF456", 102, "Volvo", 2019, 8000);
        Bus bus3 = new Bus("Bob Johnson", "GHI789", 101, "MAN", 2021, 6000);

        // Створення об'єкта BusManager
        BusManager busManager = new BusManager();

        // Додавання автобусів до BusManager
        busManager.addBus(bus1);
        busManager.addBus(bus2);
        busManager.addBus(bus3);

        // Виведення списку автобусів для заданого маршруту
        System.out.println("Список автобусів для маршруту 101:");
        ArrayList<Bus> busesForRoute = busManager.getBusesForRoute(101);
        for (Bus bus : busesForRoute) {
            System.out.println(bus);
        }

        // Виведення списку автобусів для заданого номера маршруту
        System.out.println("\nСписок автобусів з номером ABC123:");
        ArrayList<Bus> busesByNumber = busManager.getBusesByNumber("ABC123");
        for (Bus bus : busesByNumber) {
            System.out.println(bus);
        }

        // Виведення списку автобусів з пробігом більше 6000
        System.out.println("\nСписок автобусів з пробігом більше 6000:");
        ArrayList<Bus> busesWithMileageGreaterThan = busManager.getBusesWithMileageGreaterThan(6000);
        for (Bus bus : busesWithMileageGreaterThan) {
            System.out.println(bus);
        }
    }
}
