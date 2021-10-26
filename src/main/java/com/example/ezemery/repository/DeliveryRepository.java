package com.example.ezemery.repository;

import com.example.ezemery.entity.Delivery;

public interface DeliveryRepository {
    void persist(Delivery delivery);
    Delivery find(Long id);
    Delivery merge(Delivery delivery);
    void delete(Long id);
}
