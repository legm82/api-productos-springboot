package com.enrique.primerapractica.repository;

import com.enrique.primerapractica.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

