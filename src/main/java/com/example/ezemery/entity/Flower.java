package com.example.ezemery.entity;

import javax.persistence.Entity;

@Entity
public class Flower extends Plant{
    private String color;

    public Flower() {
    }

    public Flower( String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
