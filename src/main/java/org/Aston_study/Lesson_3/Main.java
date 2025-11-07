package org.Aston_study.Lesson_3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        //##############################Задание №1##############################
        System.out.println("##############################Задание №1##############################");
        Product product1 = new Product(
                "Наушники Logitech",
                LocalDate.of(2025, 8, 20),
                "Logitech Corp.",
                "Китай",
                8999.99,
                true
        );
        product1.printInfo();

        //##############################Задание №2##############################
        System.out.println("##############################Задание №2##############################");
        Product[] productsArray = new Product[5];
        productsArray[0] = product1;
        productsArray[1] = new Product("Samsung S25 Ultra",
                LocalDate.of(2025, 1, 20),
                "Samsung Corp.",
                "Korea",
                5599.00,
                true);

        productsArray[2] = new Product("Xiaomi S25 Ultra",
                LocalDate.of(2025, 1, 20),
                "Samsung Corp.",
                "Korea",
                5599.00,
                true);

        productsArray[3] = new Product("PlayStation 5 Pro",
                LocalDate.of(2025, 11, 15),
                "Sony Interactive Entertainment",
                "Япония",
                66599.99,
                false);

        productsArray[4] = new Product("Apple Watch Series 11",
                LocalDate.of(2024, 9, 10),
                "Apple Inc.",
                "США",
                70999.50,
                false);

        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Продукт №" + (i + 1));
            productsArray[i].printInfo();
        }

        //##############################Задание №3##############################
        System.out.println("##############################Задание №3##############################");

        System.out.println("==========Список аттракционов для парка Веселый Остров==========");
        Park park1 = new Park("Веселый Остров", "Москва");
        park1.addAttraction("Американские горки",
                LocalTime.of(10, 0),
                LocalTime.of(20, 0),
                350.0);
        park1.addAttraction("Колесо обозрения",
                LocalTime.of(9, 0),
                LocalTime.of(22, 0),
                200.0);

        for (Park.Attraction attraction : park1.getListOfAttractions()) {
            attraction.printAttractionInfo();
        }

        System.out.println("==========Список аттракционов для парка Диво Остров==========");
        Park park2 = new Park("Диво Остров", "Санкт-Петербург");
        park2.addAttraction("Американские горки",
                LocalTime.of(10, 0),
                LocalTime.of(20, 0),
                350.0);

        park2.addAttraction("Колесо обозрения",
                LocalTime.of(9, 0),
                LocalTime.of(22, 0),
                200.0);

        park2.addAttraction("Тарзанка",
                LocalTime.of(9, 0),
                LocalTime.of(18, 0),
                500.0);

        for (Park.Attraction attraction : park2.getListOfAttractions()) {
            attraction.printAttractionInfo();
        }
    }
}