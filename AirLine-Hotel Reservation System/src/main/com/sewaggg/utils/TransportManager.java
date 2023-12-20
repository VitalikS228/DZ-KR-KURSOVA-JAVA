package com.sewaggg.utils;

import com.sewaggg.models.Transport;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Клас, що управляє інформацією про транспорт в системі бронювання.
 *
 * Клас реалізує інтерфейс Serializable для можливості серіалізації об'єктів типу TransportManager.
 */
public class TransportManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private String filename = "transports.data";  // Ім'я файлу для збереження даних

    private Map<String, Transport> availableTransport;  // Карта доступного транспорту

    /**
     * Конструктор для створення об'єкту TransportManager.
     */
    public TransportManager() {
        this.availableTransport = new HashMap<>();
    }

    /**
     * Додати транспорт до списку доступного.
     *
     * @param route    Маршрут транспорту
     * @param transport Об'єкт типу Transport
     */
    public void addTransport(String route, Transport transport) {
        availableTransport.put(route, transport);
        saveToFile();
    }

    /**
     * Отримати копію карти доступного транспорту.
     *
     * @return Копія карти доступного транспорту
     */
    public Map<String, Transport> getAvailableTransport() {
        return new HashMap<>(availableTransport);
    }

    /**
     * Зберегти дані про транспорт у файл.
     */
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(availableTransport);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Завантажити дані про транспорт з файлу.
     * Якщо завантаження не вдається, створити порожню карту і зберегти у файл.
     */
    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            availableTransport = (Map<String, Transport>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            availableTransport = new HashMap<>();
            saveToFile();
        }
    }
}
