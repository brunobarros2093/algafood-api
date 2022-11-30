package com.algafood.jpa;

import com.algafood.AlgafoodApiApplication;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaCozinhaMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cc = applicationContext.getBean(CozinhaRepository.class);
        Cozinha cozinha = cc.buscar(1L);
        System.out.println(cozinha);

    }
}
