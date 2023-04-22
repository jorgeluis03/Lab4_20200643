package com.example.lab4_20200643.repository;

import com.example.lab4_20200643.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {

}
