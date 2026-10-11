package com.baozistore.baozistoreapi.controller;

import com.baozistore.baozistoreapi.model.Cliente;
import com.baozistore.baozistoreapi.repository.ClienteRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {


    private final ClienteRepository clienteRepository;


    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    // Criar cliente
    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    // Listar todos
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }


    // Buscar por ID
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .orElse(null);
    }


    // Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}