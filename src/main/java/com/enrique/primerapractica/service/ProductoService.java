package com.enrique.primerapractica.service;

import com.enrique.primerapractica.model.Producto;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductoService {

    Page<Producto> obtenerTodos(Pageable pageable);

    Producto obtenerPorId(Long id);
    Producto crearProducto(Producto producto);
    Producto actualizarProducto(Long id, Producto producto);
    void eliminarProducto(Long id);
}
