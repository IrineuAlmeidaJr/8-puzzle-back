package com.irineu.eightpuzzle.model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private Vertice raiz;


    public Grafo() {
    }

    public Grafo(Puzzle puzzle) {
        this.raiz = new Vertice(puzzle);
    }

    public Vertice getRaiz() {
        return raiz;
    }

}
