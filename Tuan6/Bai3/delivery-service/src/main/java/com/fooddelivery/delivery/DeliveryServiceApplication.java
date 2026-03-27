package com.fooddelivery.delivery;

import com.fooddelivery.delivery.entity.Delivery;
import com.fooddelivery.delivery.repository.DeliveryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeliveryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(DeliveryRepository deliveryRepository) {
        return args -> {
            deliveryRepository.save(new Delivery(1L, "123 Main St, NYC"));
            deliveryRepository.save(new Delivery(2L, "456 Oak Ave, LA"));
            deliveryRepository.save(new Delivery(3L, "789 Pine Rd, Chicago"));
            System.out.println("✅ Delivery Service - Sample deliveries created!");
        };
    }
}
