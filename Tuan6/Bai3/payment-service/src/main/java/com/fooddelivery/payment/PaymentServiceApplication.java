package com.fooddelivery.payment;

import com.fooddelivery.payment.entity.Payment;
import com.fooddelivery.payment.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(PaymentRepository paymentRepository) {
        return args -> {
            paymentRepository.save(new Payment(1L, 12.99, "CREDIT_CARD"));
            paymentRepository.save(new Payment(2L, 18.50, "DEBIT_CARD"));
            paymentRepository.save(new Payment(3L, 15.75, "PAYPAL"));
            System.out.println("✅ Payment Service - Sample payments created!");
        };
    }
}
