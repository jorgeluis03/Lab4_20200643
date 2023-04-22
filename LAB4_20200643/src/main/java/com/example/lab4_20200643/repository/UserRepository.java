package com.example.lab4_20200643.repository;

import com.example.lab4_20200643.entity.User;
import com.example.lab4_20200643.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String correo, String password);
    User findByEmail(String email);
}
