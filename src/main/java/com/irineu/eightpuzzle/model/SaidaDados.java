package com.irineu.eightpuzzle.model;

import java.util.List;

public class SaidaDados {

    private List<Vertice> verticesVisitados;
    private List<Vertice> verticesSolucao;
    private int qtdePassos;
    private int caminhoSolucao;
    private long tempo;


    public SaidaDados() {
    }

    public SaidaDados(List<Vertice> verticesVisitados, List<Vertice> verticesSolucao,long tempo) {
        this.verticesVisitados = verticesVisitados;
        this.verticesSolucao = verticesSolucao;
        this.qtdePassos = verticesVisitados.size();
        this.caminhoSolucao = verticesSolucao.size();
        this.tempo = tempo;
    }

    public List<Vertice> getVerticesVisitados() {
        return verticesVisitados;
    }

    public List<Vertice> getVerticesSolucao() {
        return verticesSolucao;
    }

    public int getQtdePassos() {
        return qtdePassos;
    }

    public int getCaminhoSolucao() {
        return caminhoSolucao;
    }

    public long getTempo() {
        return tempo;
    }
}
