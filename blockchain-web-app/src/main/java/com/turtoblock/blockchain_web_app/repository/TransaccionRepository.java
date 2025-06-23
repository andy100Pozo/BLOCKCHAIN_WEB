package com.turtoblock.blockchain_web_app.repository;

import com.turtoblock.blockchain_web_app.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    List<Transaccion> findByEstado(String estado);
}
