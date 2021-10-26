package com.example.ezemery.service;

import com.example.ezemery.entity.Delivery;
import com.example.ezemery.entity.RecipientAndPrice;
import com.example.ezemery.repository.DeliveryRepository;
import com.example.ezemery.repository.DeliveryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepositoryImpl deliveryRepository;

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }
}
