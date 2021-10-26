package com.example.ezemery.entity;

import java.math.BigDecimal;

public class PlantDTO {
    String name;
    BigDecimal price;

    public PlantDTO() {}

    public PlantDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

}
