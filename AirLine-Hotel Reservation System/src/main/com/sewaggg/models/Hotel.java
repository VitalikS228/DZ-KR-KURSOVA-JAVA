package com.sewaggg.models;

import java.io.Serializable;

/**
 * Клас, що представляє готель.
 *
 * Клас реалізує інтерфейс Serializable для можливості серіалізації об'єктів типу Hotel.
 */
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;            // Назва готелю
    private String address;         // Адреса готелю
    private double price;           // Вартість номера
    private int availableRooms;     // Кількість доступних номерів

    /**
     * Конструктор для створення об'єкту Hotel.
     *
     * @param name Назва готелю
     * @param address Адреса готелю
     * @param price Вартість номера
     * @param availableRooms Кількість доступних номерів
     */
    public Hotel(String name, String address, double price, int availableRooms) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.availableRooms = availableRooms;
    }

    /**
     * Отримати назву готелю.
     *
     * @return Назва готелю
     */
    public String getName() {
        return name;
    }

    /**
     * Отримати адресу готелю.
     *
     * @return Адреса готелю
     */
    public String getAddress() {
        return address;
    }

    /**
     * Отримати вартість номера.
     *
     * @return Вартість номера
     */
    public double getPrice() {
        return price;
    }

    /**
     * Отримати кількість доступних номерів.
     *
     * @return Кількість доступних номерів
     */
    public int getAvailableRooms() {
        return availableRooms;
    }

    /**
     * Забронювати номер.
     * Якщо є доступні номери, зменшити кількість доступних номерів на один.
     */
    public void bookRoom() {
        if (availableRooms > 0) {
            availableRooms--;
        }
    }

    /**
     * Скасувати бронювання номера.
     * Збільшити кількість доступних номерів на один.
     */
    public void cancelRoom() {
        availableRooms++;
    }
}
