package com.irineu.eightpuzzle.model;

import java.util.List;

public class SaidaDados {

    private String nomeMetodo;
    private List<Vertice> verticesVisitados;
    private List<Vertice> verticesSolucao;
    private int qtdePassos;
    private int caminhoSolucao;
    private long tempo;


    public SaidaDados() {
    }

    public SaidaDados(String nomeMetodo, List<Vertice> verticesVisitados, List<Vertice> verticesSolucao, long tempo) {
        this.nomeMetodo = nomeMetodo;
        this.verticesVisitados = verticesVisitados;
        this.verticesSolucao = verticesSolucao;
        this.qtdePassos = verticesVisitados.size();
        this.caminhoSolucao = verticesSolucao.size();
        this.tempo = tempo;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
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
