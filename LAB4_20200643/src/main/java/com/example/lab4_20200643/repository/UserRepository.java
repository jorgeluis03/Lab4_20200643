package com.example.lab4_20200643.repository;

import com.example.lab4_20200643.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmailAndAndPassword(String correo , String password);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into lab4.reserva (fecha_reserva, precio_total, estado_pago, user_iduser, vuelo_idvuelo)\n" +
            "\tvalues ( now(), ?1,'procesado',?2,?3)")
    void reservar (BigDecimal precio, int iduser, int idvuelo);
}
