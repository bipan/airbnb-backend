package com.pw.airbnb.repository;

import com.pw.airbnb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByEmailAndPassword(String userName, String password);

    Optional<User> findFirstByEmail(String email);
}