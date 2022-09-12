package com.irineu.eightpuzzle.model;

import com.irineu.eightpuzzle.interfaces.Size;

import java.util.ArrayList;
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

    public void gerarVertices() {
        Puzzle tempPuzzle;

        tempPuzzle = this.puzzle.moveCima();
        if (tempPuzzle != null) {
            System.out.println("Tem mater original " + puzzle.getValores());
            this.vLig[this.tl++] = new Vertice(tempPuzzle);
        }
        tempPuzzle = null;

        tempPuzzle = this.puzzle.moveBaixo();
        if (tempPuzzle != null) {
            this.vLig[this.tl++] = new Vertice(tempPuzzle);
        }
        tempPuzzle = null;

        tempPuzzle = this.puzzle.moveDireita();
        if (tempPuzzle != null) {
            this.vLig[this.tl++] = new Vertice(tempPuzzle);
        }
        tempPuzzle = null;

        tempPuzzle = this.puzzle.moveEsquerda();
        if (tempPuzzle != null) {
            this.vLig[this.tl++] = new Vertice(tempPuzzle);
        }
        tempPuzzle = null;

//        return verticesGerados;
    }
}
