package com.sewaggg.models;

import java.io.Serializable;

/**
 * Клас, що представляє транспорт.
 *
 * Клас реалізує інтерфейс Serializable для можливості серіалізації об'єктів типу Transport.
 */
public class Transport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String route;           // Маршрут транспорту
    private String type;            // Тип транспорту
    private double price;           // Вартість квитка
    private int availableSeats;     // Кількість доступних місць

    /**
     * Конструктор для створення об'єкту Transport.
     *
     * @param route Маршрут транспорту
     * @param type Тип транспорту
     * @param price Вартість квитка
     * @param availableSeats Кількість доступних місць
     */
    public Transport(String route, String type, double price, int availableSeats) {
        this.route = route;
        this.type = type;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    /**
     * Отримати маршрут транспорту.
     *
     * @return Маршрут транспорту
     */
    public String getRoute() {
        return route;
    }

    /**
     * Отримати тип транспорту.
     *
     * @return Тип транспорту
     */
    public String getType() {
        return type;
    }

    /**
     * Отримати вартість квитка.
     *
     * @return Вартість квитка
     */
    public double getPrice() {
        return price;
    }

    /**
     * Отримати кількість доступних місць.
     *
     * @return Кількість доступних місць
     */
    public int getAvailableSeats() {
        return availableSeats;
    }

    /**
     * Забронювати місце.
     * Якщо є доступні місця, зменшити кількість доступних місць на одне.
     */
    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    /**
     * Скасувати бронювання місця.
     * Збільшити кількість доступних місць на одне.
     */
    public void cancelSeat() {
        availableSeats++;
    }
}
