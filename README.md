# Desafio Técnico Prothera
Este projeto consiste em uma aplicação RESTful que simula ações de inserção, remoção, listagem, agrupamento, 
entre outras ações, de pessoas/funcionários de uma indústria. O projeto foi desenvolvido em Java, utilizando o 
Spring Boot paraauxiliar a utilização de serviços da framework Spring. As requisições de cada ação são feitas 
por meio do Postman. 
## Requisitos
- Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
– Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).
– Deve conter uma classe Principal para executar as seguintes ações:
– Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
– Remover o funcionário “João” da lista.
– Imprimir todos os funcionários com todas suas informações, sendo que:
• informação de data deve ser exibido no formato dd/mm/aaaa;
• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
– Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
– Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
– Imprimir os funcionários, agrupados por função.
– Imprimir os funcionários que fazem aniversário no mês 10 e 12.
– Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
– Imprimir a lista de funcionários por ordem alfabética.
– Imprimir o total dos salários dos funcionários.
– Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.

## API Endpoints
- POST/funcionarios/insere : Insere um funcionário
- GET/funcionarios/listaF : Lista todos os funcionários
- GET/funcionarios/aumento : Realiza um aumento de 10% no salaŕio de cada funcionário
- GET/funcionarios/funcionarioMaisVelho : Retorna o funcionário mais velho cadastrado
- GET/funcionarios/totalSalario : Retorna a soma de todos os salários
- GET/funcionarios/listaS : Lista o salário de todos os funcionários
- GET/funcionarios/listaOrdem : Lista os funcionários em ordem alfabética
- GET/funcionarios/busca/{mes} : Busca um funcionário a partir do mês da data de nascimento
- GET/funcionarios/agrupaFuncionarios : Agrupa os funcionário por função exercida
- GET/funcionarios/listaQntSM : Retorna a quantidade de salários mínimos que cada funcionário ganha
- DELETE/funcionarios/remove/{nome} : Remove um funcionário a partir do Nome
  
## Tecnologias utilizadas
- Spring Boot
- Lombok
- Spring Data Jpa
- H2
- Spring web
- Postman
- Maven

## Obersavações em relação a aplicação
- Foi utilizado o banco de dados H2. Por ser um banco dados armazenado em memória, se encaixa muito bem para as operações
  da aplicação.
- Foi utilizado a estratégia de herança JOINED no JPA para mapear a relação de hierarquia entre as entidades Pessoa e Funcionario.
  
