package org.Aston_study.Lesson_3;

import java.time.LocalTime;
import java.util.Arrays;

public class Park {
    private String parkName;
    private String parkLocation;
    private Attraction[] listOfAttractions;
    private int attractionCount;


    public Park(String parkName,String parkLocation){
        this.parkName = parkName;
        this.parkLocation = parkLocation;
        this.listOfAttractions = new Attraction[1];
        this.attractionCount = 0;
    }

    public String getParkName() {
        return parkName;
    }

    public String getParkLocation() {
        return parkLocation;
    }

    public void addAttraction(String attractionName, LocalTime startTime,
                              LocalTime endTime, double attractionPrice) {
        if (attractionCount >= listOfAttractions.length) {
            Attraction[] newArray = new Attraction[listOfAttractions.length + 1];
            System.arraycopy(listOfAttractions, 0, newArray, 0, listOfAttractions.length);
            listOfAttractions = newArray;
        }

        Attraction newAttraction = new Attraction(attractionName, startTime, endTime, attractionPrice);
        listOfAttractions[attractionCount++] = newAttraction;
    }

    public Attraction[] getListOfAttractions() {
        return Arrays.copyOf(listOfAttractions, attractionCount);
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
            System.out.println("Название парка: " + getParkName() + "\nГород: " + getParkLocation());
            System.out.println("Атракцион: " + this.attractionName);
            System.out.println("Время работы атракциона c " + this.startTime + " до " + this.endTime);
            System.out.println("Стоимость атракциона: " + attractionPrice + " рублей\n");
        }

    }
}
