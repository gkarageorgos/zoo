package com.unipi.postgraduate_JKarageorgos;

import java.io.Serializable;

public class Backbone extends Animal implements Serializable {
    private String  backbone;

    public void setBackbone(String backbone) {
        if (backbone.equals("vertebrate") || backbone.equals("invertebrate") ) {
            this.backbone = backbone;
        }else
            System.out.println("Backbone is not valid!...");
    }

    public String getBackbone() {
        return backbone;
    }

    public Backbone(String name, int averageWeight, int maxAverageAge, String backbone) {
        super(name, averageWeight, maxAverageAge);
        this.setBackbone(backbone);
    }
}

