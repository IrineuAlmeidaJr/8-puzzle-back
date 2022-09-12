package com.irineu.eightpuzzle.model;

import java.util.List;

public class Puzzle {

    private List<Character> valores;
    private int posVazio;

    public Puzzle() { }

    public Puzzle(List<Character> valores) {
        this.valores = valores;
        this.posVazio = buscaPosVazio(valores);
    }

    public List<Character> getValores() {
        return valores;
    }

    public void setValores(List<Character> valores) {
        this.valores = valores;
    }

    private int buscaPosVazio(List<Character> valores) {
        int pos = 0;
        while (pos < 9 && valores.get(pos) != ' ') {
            pos++;
        }
        return pos;
    }

    // Fazer aqui o mover Up, Down, Left, Right
    public Puzzle moveCima() {
        int posTroca = this.posVazio-3;
        Puzzle novoPuzzle = new Puzzle(valores);
        if (posTroca >= 0) {
           var tempValores = novoPuzzle.getValores();
           char valorTroca = tempValores.get(posTroca);
           // Faz a troca com vazio, com novo valor
           tempValores.set(this.posVazio, valorTroca);
           tempValores.set(posTroca, ' ');
           novoPuzzle = new Puzzle(tempValores);

            System.out.println("NOVO Cima - " + novoPuzzle.getValores());
            System.out.println("ANTIGO Cima - " + valores);
        } else {
            novoPuzzle = null;
        }
        return novoPuzzle;
    }

    public Puzzle moveBaixo() {
        int posTroca = this.posVazio+3;
        Puzzle novoPuzzle = new Puzzle(valores);
        if (posTroca < 9) {
            var tempValores = novoPuzzle.getValores();
            char valorTroca = tempValores.get(posTroca);
            // Faz a troca com vazio, com novo valor
            tempValores.set(this.posVazio, valorTroca);
            tempValores.set(posTroca, ' ');
            novoPuzzle = new Puzzle(tempValores);

            System.out.println("Baixo - " + novoPuzzle.getValores());
        } else {
            novoPuzzle = null;
        }
        return novoPuzzle;
    }

    public Puzzle moveDireita() {
        int posTroca = this.posVazio+1;
        Puzzle novoPuzzle = new Puzzle(valores);
        if (posTroca < 9 && posTroca != 3 && posTroca != 6 ) {
            var tempValores = novoPuzzle.getValores();
            char valorTroca = tempValores.get(posTroca);
            // Faz a troca com vazio, com novo valor
            tempValores.set(this.posVazio, valorTroca);
            tempValores.set(posTroca, ' ');
            novoPuzzle = new Puzzle(tempValores);

            System.out.println("Direita - " + novoPuzzle.getValores());
        } else {
            novoPuzzle = null;
        }
        return novoPuzzle;
    }

    public Puzzle moveEsquerda() {
        int posTroca = this.posVazio-1;
        Puzzle novoPuzzle = new Puzzle(valores);
        if (posTroca >= 0 && posTroca != 2 && posTroca != 5 ) {
            var tempValores = novoPuzzle.getValores();
            char valorTroca = tempValores.get(posTroca);
            // Faz a troca com vazio, com novo valor
            tempValores.set(this.posVazio, valorTroca);
            tempValores.set(posTroca, ' ');
            novoPuzzle = new Puzzle(tempValores);

            System.out.println("Esquerda - " + novoPuzzle.getValores());
        } else {
            novoPuzzle = null;
        }
        return novoPuzzle;
    }

}
