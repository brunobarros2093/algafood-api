package com.algafood.infrastructure.repository;

import com.algafood.domain.model.Cidade;
import com.algafood.domain.repository.CidadeRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cidade> listar() {
        TypedQuery<Cidade> query = entityManager.createQuery("from Cidade", Cidade.class);
        return query.getResultList();
    }

    @Override
    public Cidade buscar(Long id) {
        return entityManager.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public void remover(Cidade cozinha) {
        cozinha = buscar(cozinha.getId());
        entityManager.remove(cozinha);
    }

    @Transactional
    @Override
    public Cidade salvar(Cidade cozinha) {
        return entityManager.merge(cozinha);
    }
}
