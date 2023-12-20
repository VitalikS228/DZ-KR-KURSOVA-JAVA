package e4_1; // didn't fully understand the task

class Connection {
    private static int connection_count = 0;
    private int connection_number;

    public Connection() {
        this.connection_number = ++connection_count;
    }

    public int getConnectionNumber() {
        return connection_number;
    }
}

public class ConnectionManager {
    private static final int max_connestions = 2;
    private static Connection[] connections = new Connection[max_connestions];
    private static int current_index = 0;

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        if (current_index < max_connestions) {
            Connection new_connection = new Connection();
            connections[current_index++] = new_connection;

            System.out.println("Connection " + new_connection.getConnectionNumber() + " created.");
            return new_connection;
        } else {
            System.out.println("No more connections.");
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection1 = ConnectionManager.getConnection();
        Connection connection2 = ConnectionManager.getConnection();
        Connection connection3 = ConnectionManager.getConnection();

        if (connection3 != null) {
            System.out.println("Connection 3: " + connection3.getConnectionNumber());
        }
    }
}
