# Sempre Alerta
Projeto utilizado em exemplos de aula da disciplina Tecnologias Para Aplicações WEB

## Tema do Projeto
Um chefe escoteiro precisa, em todo encontro, fazer o controle de frequência dos escoteiros e anotar quesitos como utilização do uniforme, apresentação e participação.

Normalmente isto é realizado em um caderno de anotações, mas juntar todas as informações no final do ano é muito complicado. 

Portanto, deseja-se automatizar o processo de mensuração de resultados. Para isso será necessário ter uma aplicação web que:
* permita o cadastro dos escoteiros;
* permita o cadastro do calendário de atividades;
* permita a marcação dos itens avaliativos citados.

## Detalhes de Implementação
### Backend
* [Criação do Projeto](docs/a-criacao-do-projeto.md)
* [Modelo do Banco de Dados e Mapeamento](docs/b-banco-de-dados-e-mapeamento.md)
* [Repositórios](docs/c-repositorios.md)
* [Services e Controllers](docs/d-services-e-controller.md)

### Frontend
* [Criação do Projeto](docs/d-dependencias-frontend.md)
* Continua

## Instalação/Execução
### Requisitos
* JDK 1.8
* Cliente git

### Procedimento de Instalação e Execução (Linux/OSx)
1. Baixar o código fonte:
        
        git clone https://github.com/edussm/sempre-alerta.git
2. Acessar a pasta do projeto:

        cd sempre-alerta
3. Compilar e efetuar testes unitários
    
        ./mvnw test
4. Executar

        ./mvnw clean package
        java -jar backend/target/sempre-alerta-backend-0.0.1-SNAPSHOT.jar

5. Acessar a interface no endereço: http://localhost:8080
