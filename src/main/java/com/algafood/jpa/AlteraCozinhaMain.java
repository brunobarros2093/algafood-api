package com.algafood.jpa;

import com.algafood.AlgafoodApiApplication;
import com.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteraCozinhaMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cc = applicationContext.getBean(CadastroCozinha.class);
        Cozinha cozinha = new Cozinha();
        cozinha.setId(1L);
        cozinha.setNome("Rio grandina");
        cc.adicionar(cozinha);

    }
}
