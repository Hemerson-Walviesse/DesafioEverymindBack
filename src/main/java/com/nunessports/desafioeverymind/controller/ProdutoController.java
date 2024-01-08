package com.nunessports.desafioeverymind.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nunessports.desafioeverymind.model.Produto;
import com.nunessports.desafioeverymind.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProdutoController {
    
    private ProdutoRepository repository;

    ProdutoController(ProdutoRepository produtoRepository){
        this.repository = produtoRepository;
    }

    // Método para obter todos os produtos
    @GetMapping
    public List<Produto> findAll() {
        return repository.findAll();
    }

    // Método para obter um produto pelo ID
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return repository.findById(id)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
    }
    
    // Método para criar um novo produto
    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return repository.save(produto);
    }
    
    // Método para atualizar um produto pelo ID
    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody Produto produto) {
        return repository.findById(id)
            .map(record -> {
                record.setNomeProduto(produto.getNomeProduto());
                record.setCodigoProduto(produto.getCodigoProduto());
                record.setDescricaoProduto(produto.getDescricaoProduto());
                record.setPrecoProduto(produto.getPrecoProduto());
                Produto update = repository.save(record);
                return ResponseEntity.ok().body(update);
            }).orElse(ResponseEntity.notFound().build());
    }

    // Método para excluir um produto pelo ID
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id){
        return repository.findById(id)
            .map(record -> {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}

