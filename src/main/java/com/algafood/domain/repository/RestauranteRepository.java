package com.algafood.domain.repository;

import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscar(Long id);

    Restaurante salvar(Restaurante restaurante);

    void remover(Restaurante restaurante);
}
