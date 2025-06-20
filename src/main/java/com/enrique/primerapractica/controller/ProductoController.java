package com.enrique.primerapractica.controller;

import com.enrique.primerapractica.dto.ResponseDTO;
import com.enrique.primerapractica.model.Producto;
import com.enrique.primerapractica.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.enrique.primerapractica.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
@Tag(name = "Productos", description = "Operaciones relacionadas a productos")
public class ProductoController {

        private final ProductoService productoService;

        public ProductoController(ProductoService productoService) {
            this.productoService = productoService;
        }

    @GetMapping
    public ResponseEntity<ResponseDTO<?>> obtenerTodos(Pageable pageable) {
        Page<Producto> pagina = productoService.obtenerTodos(pageable);

        Map<String, Object> data = new HashMap<>();
        data.put("contenido", pagina.getContent());
        data.put("paginaActual", pagina.getNumber());
        data.put("totalPaginas", pagina.getTotalPages());
        data.put("totalElementos", pagina.getTotalElements());

        ResponseDTO<Object> respuesta = new ResponseDTO<>(
                "ok",
                "Listado paginado de productos",
                data
        );

        return ResponseEntity.ok(respuesta);
    }

        @GetMapping("/{id}")
        public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
            Producto producto = productoService.obtenerPorId(id);
            return producto != null ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
        }

    @PostMapping
    @Operation(
            summary = "Crear un nuevo producto",
            description = "Crea un producto enviando nombre y precio. Devuelve el producto creado.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Producto creado exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Error de validación en los datos")
            }
    )
    public ResponseEntity<ResponseDTO<Producto>> crear(@RequestBody @Valid Producto producto) {
        Producto creado = productoService.crearProducto(producto);
        ResponseDTO<Producto> respuesta = new ResponseDTO<>(
                "ok",
                "Producto creado correctamente",
                creado
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    @PutMapping("/{id}")
        public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto producto) {
            Producto actualizado = productoService.actualizarProducto(id, producto);
            return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            productoService.eliminarProducto(id);
            return ResponseEntity.noContent().build();
        }
    }
