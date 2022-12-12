package com.algafood.domain.repository;

import com.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {
    List<Permissao> listar();

    Permissao buscar(Long id);

    Permissao salvar(Permissao cozinha);

    void remover(Permissao cozinha);
}
