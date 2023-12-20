package com.sewaggg.utils;

import com.sewaggg.models.Hotel;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Клас, що управляє інформацією про готелі в системі бронювання.
 *
 * Клас реалізує інтерфейс Serializable для можливості серіалізації об'єктів типу HotelManager.
 */
public class HotelManager implements Serializable {

    private String filename = "hotels.data";   // Ім'я файлу для збереження даних
    private static final long serialVersionUID = 1L;

    private Map<String, Hotel> availableHotels; // Карта доступних готелів

    /**
     * Конструктор для створення об'єкту HotelManager.
     */
    public HotelManager() {
        this.availableHotels = new HashMap<>();
    }

    /**
     * Додати готель до списку доступних.
     *
     * @param name  Назва готелю
     * @param hotel Об'єкт типу Hotel
     */
    public void addHotel(String name, Hotel hotel) {
        availableHotels.put(name, hotel);
        saveToFile();
    }

    /**
     * Отримати копію карти доступних готелів.
     *
     * @return Копія карти доступних готелів
     */
    public Map<String, Hotel> getAvailableHotels() {
        return new HashMap<>(availableHotels);
    }

    /**
     * Зберегти дані про готелі у файл.
     */
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(availableHotels);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Завантажити дані про готелі з файлу.
     * Якщо завантаження не вдається, створити порожню карту і зберегти у файл.
     */
    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            availableHotels = (Map<String, Hotel>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            availableHotels = new HashMap<>();
            saveToFile();
        }
    }
}
