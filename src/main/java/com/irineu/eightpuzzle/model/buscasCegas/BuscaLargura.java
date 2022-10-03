package com.irineu.eightpuzzle.model.buscasCegas;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.irineu.eightpuzzle.model.Grafo;
import com.irineu.eightpuzzle.model.Vertice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuscaLargura {

    @JsonManagedReference
    private List<Vertice> verticesVisitados;
    @JsonManagedReference
    private List<Vertice> verticesGerados;
    private LinkedList<Vertice> fila;
    private Vertice solucao;
    private long tempoGasto;

    public BuscaLargura() {
        this.verticesVisitados = new ArrayList<>();
        this.verticesGerados = new ArrayList<>();
        this.fila = new LinkedList<Vertice>();
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
        solucao = vertice; // Só para quando se der erro não sair sem nada
        fila.addLast(vertice);
        while(!achou && !fila.isEmpty()) {
            qtde++;
            vertice = fila.removeFirst();
            vertice.setVerticeVisitado(vertice);
            verticesGerados.add(vertice);
            verticesVisitados.add(vertice);
            vertice.setVisitado(true);
            if (!vertice.getPuzzle().getValores().equals(objetivo)) {
                // Aqui pode gerar até 4 vertices
                vertice.gerarVertices(verticesGerados);
                for (int i=0; i < vertice.getTl(); i++) {
                    vertice.getvLig(i).setVerticesVisitados(vertice.getVerticesVisitados());
                    fila.addLast(vertice.getvLig(i));
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