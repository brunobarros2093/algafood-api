package com.algafood.domain.repository;

import com.algafood.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CozinhaRepository {
    List<Cozinha> listar();

    Cozinha buscar(Long id);

    Cozinha salvar(Cozinha cozinha);

    void remover(Cozinha cozinha);
}
