package com.sewaggg.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє користувача системи бронювання.
 *
 * Клас реалізує інтерфейс Serializable для можливості серіалізації об'єктів типу User.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;                // Ім'я користувача
    private String password;                // Пароль користувача
    private String role;                    // Роль користувача (admin або client)
    private List<String> purchasedTickets;  // Список куплених квитків
    private List<String> bookedRooms;       // Список заброньованих номерів

    /**
     * Конструктор для створення об'єкту User.
     *
     * @param username Ім'я користувача
     * @param password Пароль користувача
     * @param role Роль користувача (admin або client)
     */
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.purchasedTickets = new ArrayList<>();
        this.bookedRooms = new ArrayList<>();
    }

    /**
     * Отримати ім'я користувача.
     *
     * @return Ім'я користувача
     */
    public String getUsername() {
        return username;
    }

    /**
     * Отримати пароль користувача.
     *
     * @return Пароль користувача
     */
    public String getPassword() {
        return password;
    }

    /**
     * Отримати роль користувача.
     *
     * @return Роль користувача
     */
    public String getRole() {
        return role;
    }

    /**
     * Отримати список куплених квитків.
     *
     * @return Список куплених квитків
     */
    public List<String> getPurchasedTickets() {
        return purchasedTickets;
    }

    /**
     * Отримати список заброньованих номерів.
     *
     * @return Список заброньованих номерів
     */
    public List<String> getBookedRooms() {
        return bookedRooms;
    }

    /**
     * Додати квиток до списку куплених.
     *
     * @param ticket Квиток для додавання
     */
    public void addPurchasedTicket(String ticket) {
        purchasedTickets.add(ticket);
    }

    /**
     * Додати номер до списку заброньованих.
     *
     * @param room Номер для додавання
     */
    public void addBookedRoom(String room) {
        bookedRooms.add(room);
    }

    /**
     * Скасувати квиток.
     *
     * @param ticket Квиток для скасування
     * @return true, якщо квиток був успішно скасований; false, якщо квиток не знайдено
     */
    public boolean cancelTicket(String ticket) {
        return purchasedTickets.remove(ticket);
    }

    /**
     * Скасувати бронювання номера.
     *
     * @param room Номер для скасування бронювання
     * @return true, якщо бронювання було успішно скасовано; false, якщо номер не знайдено
     */
    public boolean cancelBookedRoom(String room) {
        return bookedRooms.remove(room);
    }
}
