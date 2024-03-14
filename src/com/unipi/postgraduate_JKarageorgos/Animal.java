package com.unipi.postgraduate_JKarageorgos;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private  int averageWeight;
    private  int maxAverageAge;

    public String getName() { return name; }

    public int getAverageWeight() {
        return averageWeight;
    }

    public int getMaxAverageAge() {
        return maxAverageAge;
    }

    public void setName(String name) { this.name = name; }

    public void setAverageWeight(int averageWeight) {
        if (averageWeight > 0 && averageWeight < 10000){
            this.averageWeight = averageWeight;
        }else
            System.out.println("Average weight is not valid!...");
    }

    public void setMaxAverageAge(int maxAverageAge) {
        if (maxAverageAge > 0 && maxAverageAge < 300){
            this.maxAverageAge = maxAverageAge;
        }else
            System.out.println("Max age is not valid!...");
    }

    public Animal(String name, int averageWeight, int maxAverageAge) {
        this.setName(name);
        this.setAverageWeight(averageWeight);
        this.setMaxAverageAge(maxAverageAge);
    }
}
