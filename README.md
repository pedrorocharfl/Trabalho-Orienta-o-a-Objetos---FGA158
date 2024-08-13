Trabalho feito por Pedro Rocha Ferreira Lima, Isaac Pinheiro de Amorim e André Gustavo Rabelo do Nascimento.
O nosso trabalho consiste em um sistema de cadastro de alunos, turmas, professores e disciplinas utilizando a linguagem Java.
O projeto está dividido em 4 pacotes, App, Cadastros, Exceptions e View.

No pacote App temos 5 classes, Aluno, Turma, Disciplina, Professor e Pessoa Fisica, onde as classes Professor e Aluno herdam a classe Pessoa Fisica. Nessas classes iremos definir as váriaveis, criar os getters e setters e métodos de sobrescrita toString.

No segundo pacote Cadastros, temos 4 classes, CadastroAluno, CadastroTurma, CadastroProfessor e CadastroDisciplina. Essas classes serão responsáveis por fazer o cadastro, atualizar, pesquisar ou remover turma, discplina, aluno e professor, e também de lançarem as exceções caso haja algum conflito

Nosso terceiro pacote é o Exceptions, que é onde temos as classes CampoEmBrancoExpection, DiscplinaNaoAtribuidaExpection, ProfessorNaoAtribuidoExpection, que são as classes onde criamos as excessões que são usadas nos outros códigos.

Nosso último pacotet é o View, onde teremos as classes MenuAluno, MenuPrincipal, MenuDisciplina, MenuProfessor e MenuTurma, classes essas que como já dito no nome será o menu de sua respectiva função, onde iremos interagir com o programa através de caixas de diálogo e executará as funções de pesquisar, cadastrar, remover e atualizar presente nos outros códigos.

O código é executado na main e apresenta as opções de cadastro, pesquisa, atualizar e remover para turma, disciplina, professor e aluno. Na opção 4 de cadastro turma temos também a opção de imprimir a lista de alunos cadastrados.


Exemplo de execução:
![image](https://github.com/user-attachments/assets/5addaaaa-4a9d-4fd6-a612-af5e504c5cbe)
![image](https://github.com/user-attachments/assets/2aa513b7-99ec-413d-a1f2-449018de1578)
![image](https://github.com/user-attachments/assets/76171aeb-e837-4eb2-be2a-969cdaa95e67)
![image](https://github.com/user-attachments/assets/1737088e-fd19-4dfa-988a-4e65b07c5341)
![image](https://github.com/user-attachments/assets/aff95142-ee8e-434d-9299-4ea5da168c43)
![image](https://github.com/user-attachments/assets/be09f6c1-9811-43a4-8dfb-1eb7efc76cbe)



