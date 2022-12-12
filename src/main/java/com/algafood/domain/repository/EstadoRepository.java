package com.algafood.domain.repository;

import com.algafood.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {
    List<Estado> listar();

    Estado buscar(Long id);

    Estado salvar(Estado cozinha);

    void remover(Estado cozinha);
}
