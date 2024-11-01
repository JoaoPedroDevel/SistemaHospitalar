# Sistema Hospitalar
Este projeto é um sistema hospitalar simples desenvolvido em Java, com funcionalidades de cadastro e gerenciamento de médicos, pacientes e consultas. Ele foi criado como parte de um exercício para organizar e acessar dados de consultas, médicos e pacientes de maneira estruturada.

Funcionalidades
O sistema possui as seguintes opções no menu principal:

Cadastrar Paciente
Permite cadastrar o nome e a data de nascimento do paciente.

Cadastrar Médico
Permite cadastrar o nome e a especialidade do médico.

Registrar Consulta
Registra uma nova consulta, associando um paciente e um médico já cadastrados e especificando o valor da consulta.

Listar Consultas
Exibe todas as consultas registradas, com o nome do paciente, do médico e o valor da consulta.

Consulta por Paciente
Exibe o histórico completo de consultas realizadas por um paciente específico, mostrando o valor total gasto.

Listar Pacientes
Lista todos os pacientes cadastrados no sistema.

Listar Médicos
Lista todos os médicos cadastrados no sistema.

Sair
Encerra o programa.

Estrutura do Projeto
O projeto está estruturado com as seguintes classes principais:

Paciente: representa os dados do paciente (nome e data de nascimento).
Medico: representa os dados do médico (nome e especialidade).
Consulta: representa uma consulta, incluindo paciente, médico e valor.
SistemaHospitalar: controla o fluxo do programa e o menu interativo para acessar as funcionalidades.
Tecnologias Utilizadas
Linguagem de Programação: Java

Como Executar
Clone o repositório:

Copiar código
git clone https://github.com/usuario/sistema-hospitalar-java.git

Compile o código:

Copiar código
javac SistemaHospitalar.java
Execute o programa:

Copiar código
java SistemaHospitalar

Autor
Desenvolvido por GRUPODOSHUMILDES.
