package com.baozistore.baozistoreapi.controller;

import com.baozistore.baozistoreapi.model.Pedido;
import com.baozistore.baozistoreapi.repository.PedidoRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {


    private final PedidoRepository pedidoRepository;


    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }


    // Criar pedido
    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }


    // Listar pedidos
    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }


    // Buscar por ID
    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElse(null);
    }


    // Deletar pedido
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}