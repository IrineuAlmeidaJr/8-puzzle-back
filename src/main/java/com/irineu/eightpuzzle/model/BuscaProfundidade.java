package com.irineu.eightpuzzle.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BuscaProfundidade {

    private List<Vertice> verticesVisitados;
    private List<Vertice> verticesGerados;
    private Stack<Vertice> pilha;

    public BuscaProfundidade() {
        this.verticesVisitados = new ArrayList<Vertice>();
        this.verticesGerados = new ArrayList<Vertice>();
        this.pilha = new Stack<Vertice>();
    }

    public List<Vertice> getVerticesGerados() {
        return verticesGerados;
    }

    public List<Vertice> getVerticesVisitados() {
        return verticesVisitados;
    }

    private void desenha(Puzzle puzzle) {
        var valores = puzzle.getValores();
        System.out.println("\n-----------");
        System.out.println("| " + valores.get(0) + "  " + valores.get(3) + "  " +valores.get(6) + " |");
        System.out.println("| " + valores.get(1) + "  " + valores.get(4) + "  " +valores.get(7) + " |");
        System.out.println("| " + valores.get(2) + "  " + valores.get(5) + "  " +valores.get(8) + " |");
        System.out.println("-----------");
    }

    public void buscar(Grafo grafo, List<Character> objetivo) {
        int qtde = 0;
        boolean achou = false;
        Vertice vertice = grafo.getRaiz();

        pilha.push(vertice);
        while(!achou && !pilha.isEmpty()) {
            qtde++;
            vertice = pilha.pop();
            verticesGerados.add(vertice);
            verticesVisitados.add(vertice);
//            System.out.println("\n\nVertice ADD -> " + vertice.getPuzzle().getValores());
            if (!vertice.getPuzzle().getValores().equals(objetivo)) {
                vertice.setVisitado(true);

                // Aqui pode gerar até 4 vertices
                vertice.gerarVertices(verticesGerados);
                for (int i=0; i < vertice.getTl(); i++) {
                    pilha.add(vertice.getvLig(i));
                    verticesGerados.add(vertice.getvLig(i));
                }
            } else {
                achou = true;
            }

            System.out.println("Qtde = " + qtde);
            desenha(vertice.getPuzzle());
//            System.out.println(vertice.getPuzzle().getValores());
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
        // TESTE
        System.out.println("\n\n *******************\n\nQuantidade TOTAL REP = " + qtde);
        System.out.println("ACHOU -> " + achou);
    }
}
