package org.example.tdd.person;

import java.util.Date;

public class Person {
    String name;
    double height;

    public Person(String name, double height) {
        this.name = name;
        this.height = height;
    }
    Home home = new Home();

    class Home {
        Address address = new Address();
        Date ownedSince;
    }

    class Address {
        int number;
        String street;
    }

}