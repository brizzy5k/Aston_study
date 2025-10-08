package org.example;


import java.time.LocalTime;

public class Park {

    public class Attraction{
        private String attractionName;
        private LocalTime startTime;
        private LocalTime endTime;
        private double attractionPrice;


        public Attraction(String attractionName,
                          LocalTime startTime,LocalTime endTime, double attractionPrice ){
            this.attractionName=attractionName;
            this.startTime=startTime;
            this.endTime=endTime;
            this.attractionPrice=attractionPrice;
        }

        public void printAttractionInfo(){
            System.out.println("Атракцион: " + this.attractionName);
            System.out.println("Время работы атракциона c " + this.startTime + " до " + this.endTime);
            System.out.println("Стоимость атракциона: " + attractionPrice + " рублей");
        }



    }




}
