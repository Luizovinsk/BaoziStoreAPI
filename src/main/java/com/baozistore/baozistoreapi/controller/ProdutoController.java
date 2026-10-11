package com.baozistore.baozistoreapi.controller;

import com.baozistore.baozistoreapi.model.Produto;
import com.baozistore.baozistoreapi.repository.ProdutoRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    private final ProdutoRepository produtoRepository;


    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    // Criar produto
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }


    // Listar produtos
    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }


    // Buscar por ID
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .orElse(null);
    }


    // Deletar produto
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}