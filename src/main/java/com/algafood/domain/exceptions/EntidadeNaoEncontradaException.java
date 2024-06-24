package com.algafood.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason = "Entidade não encontrada")
public class EntidadeNaoEncontradaException extends RuntimeException {


    public EntidadeNaoEncontradaException(String mensagem) {
       super(mensagem);
     
    }
   
}
