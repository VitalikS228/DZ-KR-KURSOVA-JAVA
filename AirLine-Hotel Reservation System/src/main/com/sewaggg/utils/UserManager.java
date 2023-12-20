package com.sewaggg.utils;

import com.sewaggg.models.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Клас, що управляє інформацією про користувачів системи бронювання.
 *
 * Клас реалізує інтерфейс Serializable для можливості серіалізації об'єктів типу UserManager.
 */
public class UserManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private String filename = "users.data";  // Ім'я файлу для збереження даних
    private Map<String, User> userMap;       // Карта користувачів

    /**
     * Конструктор для створення об'єкту UserManager.
     */
    public UserManager() {
        this.userMap = new HashMap<>();
    }

    /**
     * Додати користувача до списку.
     *
     * @param username Ім'я користувача
     * @param user     Об'єкт типу User
     */
    public void addUser(String username, User user) {
        userMap.put(username, user);
        saveToFile();
    }

    /**
     * Отримати копію карти користувачів.
     *
     * @return Копія карти користувачів
     */
    public Map<String, User> getUserMap() {
        return new HashMap<>(userMap);
    }

    /**
     * Аутентифікація користувача за ім'ям користувача та паролем.
     *
     * @param username Ім'я користувача
     * @param password Пароль користувача
     * @return Об'єкт типу User, якщо аутентифікація успішна; null, якщо невірні ім'я користувача або пароль
     */
    public User authenticateUser(String username, String password) {
        if (userMap.containsKey(username)) {
            User user = userMap.get(username);
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Зберегти дані про користувачів у файл.
     */
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(userMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Завантажити дані про користувачів з файлу.
     * Якщо завантаження не вдається, створити порожню карту і зберегти у файл.
     */
    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            userMap = (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            userMap = new HashMap<>();
            saveToFile();
        }
    }
}
