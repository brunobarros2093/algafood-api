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

    private static final String COZINHA_ESTA_EM_USO_NÃO_PODE_SER_REMOVIDA = "Cozinha esta em uso. Não pode ser removida: ";
    private static final String COZINHA_ID_NÃO_ENCONTRADO = "Cozinha ID não encontrado";
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
            throw new EntidadeEmUsoException(COZINHA_ESTA_EM_USO_NÃO_PODE_SER_REMOVIDA + e.getMessage());
        } catch(EmptyResultDataAccessException e ){
            throw new EntidadeNaoEncontradaException(COZINHA_ID_NÃO_ENCONTRADO);
        }

    }

    public Cozinha buscarOuFalhar(Long cozinhaId){
        return cozinhaRepository.findById(cozinhaId).orElseThrow(()-> new EntidadeNaoEncontradaException("Cozinha não encontrada"));
    }

}
