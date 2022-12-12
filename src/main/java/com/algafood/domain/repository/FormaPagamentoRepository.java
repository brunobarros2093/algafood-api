package com.algafood.domain.repository;

import com.algafood.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {
    List<FormaPagamento> listar();

    FormaPagamento buscar(Long id);

    FormaPagamento salvar(FormaPagamento cozinha);

    void remover(FormaPagamento cozinha);
}
