package com.baozistore.baozistoreapi.repository;

import com.baozistore.baozistoreapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}