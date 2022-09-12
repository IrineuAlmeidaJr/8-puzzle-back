package com.irineu.eightpuzzle.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuscaProfundidade {

    private List<Vertice> verticesGerados;
    private LinkedList<Vertice> fila;

    public BuscaProfundidade() {
        this.verticesGerados = new ArrayList<Vertice>();
        this.fila = new LinkedList<>();
    }

    public List<Vertice> getVerticesGerados() {
        return verticesGerados;
    }

    public void buscar(Grafo grafo, List<Character> objetivo) {
        int qtde = 0;
        boolean achou = false;
        Vertice vertice = grafo.getRaiz();

        fila.addFirst(vertice);
        while(!achou && !fila.isEmpty()) {
            qtde++;
            vertice = fila.removeFirst();
            verticesGerados.add(vertice);
            System.out.println("\n\nVertice ADD -> " + vertice.getPuzzle().getValores());
            if (!vertice.getPuzzle().getValores().equals(objetivo)) {
                vertice.setVisitado(true);

                // Aqui pode gerar até 4 vertices
                vertice.gerarVertices();
                for (int i=0; i < vertice.getTl(); i++) {
                    fila.add(vertice.getvLig(i));
                }
            } else {
                achou = true;
            }

            System.out.println("Qtde = " + qtde);
            System.out.println(vertice.getPuzzle().getValores());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // TESTE
        System.out.println("Quantidade TOTAL REP = " + qtde);
        System.out.println("ACHOU -> " + achou);
    }
}
