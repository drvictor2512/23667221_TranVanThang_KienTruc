package com.fooddelivery.delivery.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private String driverName;
    private String driverPhone;
    private String status;
    private String deliveryAddress;
    private String createdAt;

    public Delivery() {}
    public Delivery(Long orderId, String deliveryAddress) {
        this.orderId = orderId;
        this.deliveryAddress = deliveryAddress;
        this.driverName = "Driver-" + System.currentTimeMillis();
        this.driverPhone = "+1-555-" + (1000 + (int)(Math.random() * 8999));
        this.status = "ASSIGNED";
        this.createdAt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public String getDriverPhone() { return driverPhone; }
    public void setDriverPhone(String driverPhone) { this.driverPhone = driverPhone; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    public String getCreatedAt() { return createdAt; }
}
