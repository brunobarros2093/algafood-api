package com.algafood.domain.repository;

import com.algafood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    List<Restaurante> findRestauranteByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

}
