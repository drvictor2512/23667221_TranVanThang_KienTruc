package com.fooddelivery.order.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String restaurantName;
    private String items;
    private Double totalPrice;
    private String status;
    private String createdAt;

    public Order() {}
    public Order(String restaurantName, String items, Double totalPrice) {
        this.restaurantName = restaurantName;
        this.items = items;
        this.totalPrice = totalPrice;
        this.status = "PENDING";
        this.createdAt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }
    public String getItems() { return items; }
    public void setItems(String items) { this.items = items; }
    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getCreatedAt() { return createdAt; }
}
