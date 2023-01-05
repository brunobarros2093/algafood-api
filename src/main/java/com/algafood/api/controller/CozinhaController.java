package com.algafood.api.controller;


import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;
import com.algafood.infrastructure.repository.CozinhaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepositoryImpl cozinhaRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }

    @GetMapping("/{id}")
    public Cozinha buscar(@PathVariable Long id) {
        return cozinhaRepository.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody Cozinha cozinha) {
        cozinhaRepository.salvar(cozinha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> update(@RequestBody Cozinha cozinhaAtual, @PathVariable Long id) {
        Cozinha cozinhaEditada = cozinhaRepository.update(cozinhaAtual, id);
        if (cozinhaEditada != null) {
            return ResponseEntity.ok(cozinhaEditada);
        }
        return ResponseEntity.notFound().build();
    }
}
