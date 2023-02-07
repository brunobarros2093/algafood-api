package com.algafood.domain.repository;

import com.algafood.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {
    List<Cozinha> listar();
    List<Cozinha> consultaPorNome(String nome);
    Cozinha buscar(Long id);

    Cozinha salvar(Cozinha cozinha);

    void remover(Long id);

}
