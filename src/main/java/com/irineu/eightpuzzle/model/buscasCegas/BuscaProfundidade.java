package com.irineu.eightpuzzle.model.buscasCegas;

import com.irineu.eightpuzzle.model.Grafo;
import com.irineu.eightpuzzle.model.Vertice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuscaProfundidade {

    private List<Vertice> verticesVisitados;
    private List<Vertice> verticesGerados;
    private Stack<Vertice> pilha;
    private Vertice solucao;
    private long tempoGasto;

    public BuscaProfundidade() {
        this.verticesVisitados = new ArrayList<Vertice>();
        this.verticesGerados = new ArrayList<Vertice>();
        this.pilha = new Stack<Vertice>();
    }

    public List<Vertice> getVerticesVisitados() {
        return verticesVisitados;
    }

    public List<Vertice> getSolucao() {
        return solucao.getVerticesVisitados();
    }

    public long getTempoGasto() {
        return tempoGasto;
    }

    public void buscar(Grafo grafo, List<Character> objetivo) {
        int qtde = 0;
        long tini, tfim;
        boolean achou = false;
        tini = System.currentTimeMillis();
        Vertice vertice = grafo.getRaiz();
        this.solucao = vertice; // Só para quando se der erro não sair sem nada
        pilha.push(vertice);
        while(!achou && !pilha.isEmpty()) {
            qtde++;
            vertice = pilha.pop();
            vertice.setVerticeVisitado(vertice);
            verticesGerados.add(vertice);
            verticesVisitados.add(vertice);
            vertice.setVisitado(true);
            if (!vertice.getPuzzle().getValores().equals(objetivo)) {
                // Aqui pode gerar até 4 vertices
                vertice.gerarVertices(verticesGerados);
                for (int i=0; i < vertice.getTl(); i++) {
                    vertice.getvLig(i).setVerticesVisitados(vertice.getVerticesVisitados());
                    pilha.add(vertice.getvLig(i));
                    verticesGerados.add(vertice.getvLig(i));
                }
            } else {
                solucao = vertice;
                achou = true;
            }
        }
        tfim = System.currentTimeMillis();
        this.tempoGasto = tfim - tini;
    }
}