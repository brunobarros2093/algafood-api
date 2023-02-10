package com.algafood.api.controller;


import com.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;
import com.algafood.domain.service.CadastroCozinhaService;
import com.algafood.domain.exceptions.EntidadeEmUsoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cozinhaService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar() {
        return cozinhaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
        Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

        if (cozinha.isPresent()) {
            return ResponseEntity.ok(cozinha.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
        return cozinhaService.salvar(cozinha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> update(@RequestBody Cozinha cozinha, @PathVariable Long id) {
        Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(id);
        if (cozinhaAtual.isPresent()) {
            BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id");
            cozinhaAtual = Optional.of(cozinhaRepository.save(cozinha));
            return ResponseEntity.ok(cozinhaAtual.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> delete(@PathVariable Long id) {
        try {
            cozinhaService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
