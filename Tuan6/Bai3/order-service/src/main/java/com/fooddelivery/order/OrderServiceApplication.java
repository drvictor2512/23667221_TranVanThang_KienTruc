package com.fooddelivery.order;

import com.fooddelivery.order.entity.Order;
import com.fooddelivery.order.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(OrderRepository orderRepository) {
        return args -> {
            orderRepository.save(new Order("Pho King Good", "Pho Beef, Spring Roll", 12.99));
            orderRepository.save(new Order("Pizza Palace", "Margherita Pizza, Coke", 18.50));
            orderRepository.save(new Order("Burger Zone", "Cheeseburger, Fries, Shake", 15.75));
            System.out.println("✅ Order Service - Sample orders created!");
        };
    }
}
