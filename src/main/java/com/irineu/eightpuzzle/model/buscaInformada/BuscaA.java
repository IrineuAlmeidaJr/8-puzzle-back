package com.irineu.eightpuzzle.model.buscaInformada;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.irineu.eightpuzzle.model.Grafo;
import com.irineu.eightpuzzle.model.Vertice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuscaA {

    @JsonManagedReference
    private List<Vertice> verticesVisitados;
    @JsonManagedReference
    private List<Vertice> verticesGerados;
    private LinkedList<Vertice> fila;
    private Vertice solucao;
    private long tempoGasto;

    public BuscaA() {
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

    private void filaPrioridade(Vertice vertice) {
        int novoFaFc = vertice.getFaFc();
        int pos = 0;
        int tamanho = fila.size();
        while(pos < tamanho && novoFaFc >= fila.get(pos).getFaFc()) {
            // maior ou igual porque ele tem inserir no final se for igual
            pos++;
        }
        // Remaneja
        if(pos < tamanho) {
            fila.add(pos, vertice);
        } else {
            fila.addLast(vertice);
        }

//        fila.add(fila.get(fila.size()));
//        fila.add(pos, vertice);
    }

    public void buscar(Grafo grafo, List<Character> objetivo) {
        int qtde = 0;
        int fc;
        long tini, tfim;
        boolean achou = false;
        tini = System.currentTimeMillis();
        Vertice vertice = grafo.getRaiz();
        solucao = vertice; // Só para quando se der erro não sair sem nada
        vertice.calculaFa(objetivo); // --> ARRUMAR
        vertice.setFc(0);
        fila.addLast(vertice);
        while(!achou && !fila.isEmpty()) {
            qtde++;
            vertice = fila.removeFirst();
            System.out.println("Tamanho -> " + vertice.getFc());
            vertice.setVerticeVisitado(vertice);
            verticesGerados.add(vertice);
            verticesVisitados.add(vertice);
            vertice.setVisitado(true);
            if (!vertice.getPuzzle().getValores().equals(objetivo)) {
                // Aqui pode gerar até 4 vertices
                vertice.gerarVertices(verticesGerados);
                for (int i=0; i < vertice.getTl(); i++) {
                    vertice.getvLig(i).setVerticesVisitados(vertice.getVerticesVisitados());
                    vertice.getvLig(i).calculaFa(objetivo); // --> ARRUMAR
                    fc = vertice.getFc();
                    vertice.getvLig(i).setFc(fc+1); // Soma com anterior o FC
                    // Adicionar conforme prioridade que é quem tiver
                    // a menor FA+FC primeiro
                    verticesGerados.add(vertice.getvLig(i));
                    filaPrioridade(vertice.getvLig(i));
                    // *** OLHA A QUESTE DE INSERÇÃo
//                    fila.addLast(vertice.getvLig(i)); // AI AQUI NÃO TEM
                }
            } else {
                solucao = vertice;
                achou = true;
            }
            vertice.desenha();
            System.out.println("CUSTO - > " + vertice.getFc());
        }
        System.out.println("TAMANHO FINAl -> " + fila.size());
        tfim = System.currentTimeMillis();
        this.tempoGasto = tfim - tini;
    }



}
