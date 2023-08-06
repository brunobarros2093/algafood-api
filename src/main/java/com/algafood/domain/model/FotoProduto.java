package com.algafood.domain.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FotoProduto {
    private String nome;
    private String descricao;
    private String contentType;
    private Long tamanho;
}
