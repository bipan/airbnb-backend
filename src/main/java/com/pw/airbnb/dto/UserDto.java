package com.pw.airbnb.dto;

import com.pw.airbnb.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String name;
    private String email;
    private UserRole userRole;
}
