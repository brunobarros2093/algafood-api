package com.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepository;
@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @Override
    public List<Restaurante> listar() {
        return null;
    }

    @Override
    public Restaurante buscar(Long id) {
        return null;
    }

    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return null;
    }

    @Override
    public void remover(Restaurante restaurante) {

    }
}
