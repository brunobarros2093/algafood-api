package com.algafood.domain.repository;

import com.algafood.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {
    List<Cidade> listar();

    Cidade buscar(Long id);

    Cidade salvar(Cidade cozinha);

    void remover(Cidade cozinha);
}
