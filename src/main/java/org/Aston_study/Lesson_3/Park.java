package org.Aston_study.Lesson_3;


import java.time.LocalTime;

public class Park {
    private String parkName;
    private String parkLocation;

    public Park(String parkName,String parkLocation){
        this.parkName=parkName;
        this.parkLocation=parkLocation;
    }

    public String getParkName() {
        return parkName;
    }

    public String getParkLocation() {
        return parkLocation;
    }

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
            System.out.println("Название парка: " + getParkName() + "\nСтрана: " + getParkLocation());
            System.out.println("Атракцион: " + this.attractionName);
            System.out.println("Время работы атракциона c " + this.startTime + " до " + this.endTime);
            System.out.println("Стоимость атракциона: " + attractionPrice + " рублей\n");
        }

    }




}
