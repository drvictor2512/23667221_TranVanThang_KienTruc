package com.partition.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users_suspended")
public class UserSuspended {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status = "Suspended";
    private String lastLogin;

    public UserSuspended() {}
    public UserSuspended(String name, String lastLogin) {
        this.name = name;
        this.lastLogin = lastLogin;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getStatus() { return status; }
    public String getLastLogin() { return lastLogin; }
    public void setLastLogin(String lastLogin) { this.lastLogin = lastLogin; }
}
