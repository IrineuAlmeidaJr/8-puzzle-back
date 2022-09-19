package com.irineu.eightpuzzle.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuscaLargura {


    private List<Vertice> verticesVisitados;
    private List<Vertice> verticesGerados;
    private LinkedList<Vertice> fila;

    public BuscaLargura() {
        this.verticesVisitados = new ArrayList<>();
        this.verticesGerados = new ArrayList<>();
        this.fila = new LinkedList<Vertice>();
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

        fila.addLast(vertice);
        while(!achou && !fila.isEmpty()) {
            qtde++;
            vertice = fila.removeFirst();
            verticesGerados.add(vertice);
            verticesVisitados.add(vertice);
            if (!vertice.getPuzzle().getValores().equals(objetivo)) {
                vertice.setVisitado(true);

                // Aqui pode gerar até 4 vertices
                vertice.gerarVertices(verticesGerados);
                for (int i=0; i < vertice.getTl(); i++) {
                    fila.addLast(vertice.getvLig(i));
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

        // --> TESTE
        System.out.println("\n\n *******************\n\nQuantidade TOTAL REP = " + qtde);
        System.out.println("ACHOU -> " + achou);
    }

}
