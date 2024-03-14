package com.unipi.postgraduate_JKarageorgos;

import java.io.Serializable;

public class ZooAnimal extends Division implements Serializable, IEat{
    private final String ID;

    private static int i = 0;

    public static void setI(int i) {
        ZooAnimal.i = i;
    }

    public static int getI() {
        return i;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "ZooAnimal{" +
                "ID='" + ID + '\'' +
                ", name='" + getName() + '\'' +
                ", backbone='" + getBackbone() + '\'' +
                ", division='" + getDivision() + '\'' +
                ", averageWeight=" + getAverageWeight() +
                ", maxAverageAge=" + getMaxAverageAge() +
                '}';
    }

    public ZooAnimal(String name, int averageWeight, int maxAverageAge, String backbone, String division) {
        super(name, averageWeight, maxAverageAge, backbone, division);
        i+=1;
        if (i < 10)
            ID = getName()+"0"+i;
        else
            ID = getName()+i;
    }

    @Override
    public void eating() {
        System.out.println(getName() + " has been fed");
    }
}
