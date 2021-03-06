package com.example.ezemery.entity;

import java.math.BigDecimal;

public class RecipientAndPrice {
    private String name;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public RecipientAndPrice() {
    }

    public RecipientAndPrice(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
