package com.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public void excluir(Long id) {
        // busca cozinha, se existir deleta
        try {
            cozinhaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Cozinha esta em uso. Não pode ser removida: " + e.getMessage());
        } catch(EmptyResultDataAccessException e ){
            throw new EntidadeNaoEncontradaException("Cozinha ID não encontrado");
        }

    }

}
