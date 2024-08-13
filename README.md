Trabalho feito por Pedro Rocha Ferreira Lima, Isaac Pinheiro de Amorim e André Gustavo Rabelo do Nascimento.
O nosso trabalho consiste em um sistema de cadastro de alunos, turmas, professores e disciplinas utilizando a linguagem Java.
O projeto está dividido em 4 pacotes, App, Cadastros, Exceptions e View.

No pacote App temos 5 classes, Aluno, Turma, Disciplina, Professor e Pessoa Fisica, onde as classes Professor e Aluno herdam a classe Pessoa Fisica. Nessas classes iremos definir as váriaveis, criar os getters e setters e métodos de sobrescrita toString.

No segundo pacote Cadastros, temos 4 classes, CadastroAluno, CadastroTurma, CadastroProfessor e CadastroDisciplina. Essas classes serão responsáveis por fazer o cadastro, atualizar, pesquisar ou remover turma, discplina, aluno e professor, e também de lançarem as exceções caso haja algum conflito

Nosso terceiro pacote é o Exceptions, que é onde temos as classes CampoEmBrancoExpection, DiscplinaNaoAtribuidaExpection, ProfessorNaoAtribuidoExpection, que são as classes onde criamos as excessões que são usadas nos outros códigos.

Nosso último pacotet é o View, onde teremos as classes MenuAluno, MenuPrincipal, MenuDisciplina, MenuProfessor e MenuTurma, classes essas que como já dito no nome será o menu de sua respectiva função, onde iremos interagir com o programa através de caixas de diálogo e executará as funções de pesquisar, cadastrar, remover e atualizar presente nos outros códigos.
