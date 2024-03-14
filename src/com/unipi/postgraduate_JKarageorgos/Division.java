package com.unipi.postgraduate_JKarageorgos;

import java.io.Serializable;

public class Division extends Backbone implements Serializable {
    private String division;

    public void setDivision(String division) {
        if (division.equals("mammal") || division.equals("bird") || division.equals("fish") || division.equals("reptile")){
            this.division = division;
        }else
            System.out.println("Division is not valid!...");
    }

    public String getDivision() {
        return division;
    }

    public Division(String name, int averageWeight, int maxAverageAge, String backbone, String division) {
        super(name, averageWeight, maxAverageAge, backbone);
        this.setDivision(division);
    }
}
