package com.example.ezemery.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NamedQuery(
    name = "Delivery.getDeliveryByName",
    query = "select d from Delivery d where d.name = :name"
)

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name="address_full", length = 500)
    private String address;
    private LocalDate deliveryDate;
    private LocalDateTime deliveryTime;
    @Type(type = "yes_no")
    private Boolean completed;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plants;

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public Delivery() {
    }

    public Delivery(Long id, String name, String address, LocalDate deliveryDate, LocalDateTime deliveryTime, Boolean completed) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.completed = completed;
    }

    public Delivery(String name, String address, LocalDateTime deliveryTime) {
        this.name = name;
        this.address = address;
        this.deliveryTime = deliveryTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
