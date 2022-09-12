package com.irineu.eightpuzzle.model;

import com.irineu.eightpuzzle.interfaces.Size;

import java.util.List;

public class Vertice implements Size {

    private Puzzle puzzle;
    Vertice vLig[];
    Boolean visitado;
    int tl;

    public Vertice(Puzzle puzzle) {
        this.puzzle = puzzle;
        this.vLig = new Vertice[N];
        this.visitado = false;
        this.tl = 0;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public Vertice getvLig(int pos) {
        return vLig[pos];
    }

    public void setvLig(int pos, Vertice lig) {
        this.vLig[pos] = lig;
    }

    public Boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
    }

    public int getTl() {
        return tl;
    }

    public void setTl(int tl) {
        this.tl = tl;
    }


    private boolean verificaNovoVertice(Puzzle gerado, List<Vertice> verticesVisitados) {
        int pos = 0;
        boolean naoAchou = true;
        while(pos < verticesVisitados.size() && naoAchou) {
            if(verticesVisitados.get(pos).getPuzzle().getValores().equals(gerado.getValores())) {
                naoAchou = false;
            }
            pos++;
        }
        return naoAchou; // neguei aqui pq se não dentro do laço teria ficar perguntando
        // !naoAchou ou !achou, aqui uso not uma única vez antes de retornar
    }

    public void gerarVertices(List<Vertice> verticesVisitados) {
        Puzzle tempPuzzle;

        tempPuzzle = this.puzzle.moveCima();
        if (tempPuzzle != null && verificaNovoVertice(tempPuzzle, verticesVisitados)) {
            System.out.println("Tem mater original " + puzzle.getValores());
            this.vLig[this.tl++] = new Vertice(tempPuzzle);

        }

        tempPuzzle = this.puzzle.moveBaixo();
        if (tempPuzzle != null && verificaNovoVertice(tempPuzzle, verticesVisitados)) {
            this.vLig[this.tl++] = new Vertice(tempPuzzle);
        }

        tempPuzzle = this.puzzle.moveDireita();
        if (tempPuzzle != null && verificaNovoVertice(tempPuzzle, verticesVisitados)) {
            this.vLig[this.tl++] = new Vertice(tempPuzzle);
        }

        tempPuzzle = this.puzzle.moveEsquerda();
        if (tempPuzzle != null && verificaNovoVertice(tempPuzzle, verticesVisitados)) {
            this.vLig[this.tl++] = new Vertice(tempPuzzle);
        }

//        return verticesGerados;
    }
}
