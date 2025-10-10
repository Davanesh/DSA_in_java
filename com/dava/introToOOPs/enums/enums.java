package com.dava.introToOOPs.enums;

public class enums {
    enum Week {
        sunday,
        Monday,
        Tuesday,
        wednesday,
        Thursday,
        Friday,
        Saturday
    }

    public static void main(String[] args) {
        Week week;
        week = Week.Monday;

        for (Week day : Week.values()) {
            System.out.println(day);
        }
    }
}
