package com.algafood.domain.repository;

import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();
    Cozinha buscar(Long id);

    Cozinha salvar(Cozinha cozinha);

    void remover(Cozinha cozinha);
}
