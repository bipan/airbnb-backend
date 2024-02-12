package com.pw.airbnb.controller;

import com.pw.airbnb.dto.SignupRequest;
import com.pw.airbnb.dto.UserDto;
import com.pw.airbnb.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airbnb/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        if  (authService.hasCustomerWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("Customer already exist with this email", HttpStatus.NOT_ACCEPTABLE);
        UserDto createdCustmerDto = authService.createCustomer(signupRequest);
        if (createdCustmerDto == null) return new ResponseEntity<>
                ("Customer not created", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdCustmerDto, HttpStatus.CREATED);
    }
}
