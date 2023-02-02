package com.algafood.domain.service;

import com.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.CozinhaRepository;
import com.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;
    public Restaurante salvar(Restaurante restaurante) {

        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha =  cozinhaRepository.buscar(cozinhaId);
        if(cozinha == null) {
            throw new EntidadeNaoEncontradaException("Cozinha não encontrada");
        }
        restaurante.setCozinha(cozinha);
        return restauranteRepository.salvar(restaurante);
    }

}
