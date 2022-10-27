# spring-formacao-alura
Atividades desenvolvidas na formação Spring Framework da Alura. 

## Curso IV: Java e JDBC
Neste curso criei um CRUD de produtos, armazendo-os em um banco de dados MariaDB. Todo o CRUD foi organizado sob o padrão DAO (*Data Access Objects*);

Cada produto contém um nome, uma descrição, um identificador e uma categoria. Desses atributos, somente a categoria foi armazenada em uma tabela externa, sendo acessada por uma chave estrangeira.

Não implementei dois assuntos vistos no curso por não serem úteis em uma aplicação tão simples: o *pool* de conexões e o controle de transações usando *commit* e *rollback*.
