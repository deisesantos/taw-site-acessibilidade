package br.fpu.taw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcessibilidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcessibilidadeApplication.class, args);
	}
}

/*
 * Notas:

@SpringBootApplication é uma anotação para:

    @Configuration marca a classe como a fonte de definições 
    de beans para o contexto da aplicação

    @EnableAutoConfiguration diz ao Spring Boot para adicionar
     beans baseados nas configuraçoes de 
    classpath e varias propriedades
    
    @ComponentScan diz ao Spring para procurar por coponentes, 
    configurações e servicos no pacote 
    da classe

 * 
 */