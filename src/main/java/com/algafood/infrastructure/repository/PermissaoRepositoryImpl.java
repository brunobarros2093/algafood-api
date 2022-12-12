package com.algafood.infrastructure.repository;

import com.algafood.domain.model.Permissao;
import com.algafood.domain.repository.PermissaoRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Permissao> listar() {
        TypedQuery<Permissao> query = entityManager.createQuery("from Permissao", Permissao.class);
        return query.getResultList();
    }

    @Override
    public Permissao buscar(Long id) {
        return entityManager.find(Permissao.class, id);
    }

    @Transactional
    @Override
    public void remover(Permissao cozinha) {
        cozinha = buscar(cozinha.getId());
        entityManager.remove(cozinha);
    }

    @Transactional
    @Override
    public Permissao salvar(Permissao cozinha) {
        return entityManager.merge(cozinha);
    }
}
