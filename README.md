<h1 align="center">8 Puzzle Backend </h1>
<p align="justify">Projeto realizado visando solucionar o problema 8 puzzle, para tanto foi necessário a criação de uma interface com usuário, para tanto foi desenvolvida uma aplicação web onde o usuário informa as entrada, objetivo, qual algoritmo deseja utiliza na solução, a qual é enviado por meio de JSON para o backend, onde este irá tratar aa situações. </br>
Para solução foi utilizado de uma estrutura baseada e Árvore N-Area, que poderá possuir uma ou até quatro ligações, para gerar as possíveis movimentações que é permitida no jogo, utiliza de uma lista que guarda as movimentações realizadas para não permitindo uma geração de movimentação que já foi realizada. </br>
Foi implementado buscas não informadas BFS e DFS, bem com a busca informada A* personalizada para o problema, utilizando da heurística da distância manhattan. </br>
Adotou Spring para fazer essa comunicação entre aplicação web, irá solucionar o problema e retornar um JSON.</p>

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=%20CONCLUIDO&color=GREEN&style=for-the-badge"/>
</p>

<h2 align="center"><a href="https://8-puzzle-front.vercel.app">Clique aqui para ver meu projeto!</a></h2>
 <strong>OBS1</strong>: devido o deploy realizado no heroku de forma gratuita, em alguns casos irá demorar para obter o resultado. Demora conectar na primeira tentativa</br>
 <strong>OBS2</strong>: BFS é um método de busca mais demorado, pode ser que solução não seja encontrada em um tempo hábil. 


## 🖥️ Tecnologías Utilizadas:

- Java 17 </br>
- Spring </br>
 
## Instalação

    - Clonar repositorio
    $ git clone https://github.com/IrineuAlmeidaJr/8-puzzle-back.git

    - Instalar
    $ Java 17

    - Rodar aplicativo
    $ VScode ou IDE de sua prerefência

 
