package com.algafood.jpa;

import com.algafood.AlgafoodApiApplication;
import com.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class InclusaoaCozinhaMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Brasileira");
        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Japonesa");


        cadastroCozinha.adicionar(cozinha1);
        cadastroCozinha.adicionar(cozinha2);

    }
}
