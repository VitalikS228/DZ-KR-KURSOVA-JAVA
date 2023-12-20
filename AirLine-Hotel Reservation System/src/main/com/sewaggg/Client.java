package com.sewaggg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Клас Client відповідає за взаємодію клієнта із сервером.
 */
public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    /**
     * Точка входу у програму для клієнтської частини.
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    /**
     * Метод start ініціалізує та запускає клієнтську частину програми.
     */
    private void start() {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("З'єднання з сервером встановлено.");

            // Оновлений потік для читання відповідей від сервера
            Thread responseThread = new Thread(() -> {
                try {
                    String serverResponse;
                    while ((serverResponse = reader.readLine()) != null) {
                        if(serverResponse.equals("exit"))
                            System.exit(0);
                        System.out.println(serverResponse);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            responseThread.start();

            // Потік для надсилання даних на сервер
            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                writer.println(userInputLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
