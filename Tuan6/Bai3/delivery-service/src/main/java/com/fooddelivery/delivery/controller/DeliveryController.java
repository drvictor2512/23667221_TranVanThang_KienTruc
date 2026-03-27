package com.fooddelivery.delivery.controller;

import com.fooddelivery.delivery.entity.Delivery;
import com.fooddelivery.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
@CrossOrigin(origins = "*")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public Delivery assignDelivery(@RequestBody Delivery delivery) {
        return deliveryService.assignDelivery(delivery);
    }

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public Delivery getDelivery(@PathVariable Long id) {
        return deliveryService.getDeliveryById(id);
    }

    @PutMapping("/{id}/status")
    public Delivery updateDeliveryStatus(@PathVariable Long id, @RequestParam String status) {
        return deliveryService.updateDeliveryStatus(id, status);
    }
}
