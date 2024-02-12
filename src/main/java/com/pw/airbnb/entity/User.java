package com.pw.airbnb.entity;

import com.pw.airbnb.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private String email;
    private UserRole userRole;

}
