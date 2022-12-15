package com.algafood.infrastructure.repository;

import com.algafood.domain.model.Estado;
import com.algafood.domain.repository.EstadoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Estado> listar() {
        TypedQuery<Estado> query = entityManager.createQuery("from Estado", Estado.class);
        return query.getResultList();
    }

    @Override
    public Estado buscar(Long id) {
        return entityManager.find(Estado.class, id);
    }

    @Transactional
    @Override
    public void remover(Estado cozinha) {
        cozinha = buscar(cozinha.getId());
        entityManager.remove(cozinha);
    }

    @Transactional
    @Override
    public Estado salvar(Estado cozinha) {
        return entityManager.merge(cozinha);
    }
}
