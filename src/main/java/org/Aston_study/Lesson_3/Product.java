package org.Aston_study.Lesson_3;

import java.time.LocalDate;

public class Product {
    private String productName;
    private LocalDate productionDate;
    private String manufacturerName;
    private String manufacturerCountry;
    private double productPrice;
    private boolean isReserved;

    public Product(String name, LocalDate productionDate, String manufacturerName,
                   String manufacturerCountry, double price, boolean isReserved) {
        this.productName = name;
        this.productionDate = productionDate;
        this.manufacturerName = manufacturerName;
        this.manufacturerCountry = manufacturerCountry;
        this.productPrice = price;
        this.isReserved = isReserved;
    }

    public void printInfo(){
        System.out.println("Название продукта: " + this.productName);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturerName);
        System.out.println("Страна производства: " + manufacturerCountry);
        System.out.println("Цена товара: " + productPrice);
        System.out.println("Состояние бронирования покупателем: " + (isReserved ? "Свободен\n" : "Зарезирвирован\n"));
    }
}
