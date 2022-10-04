package com.irineu.eightpuzzle.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.irineu.eightpuzzle.interfaces.Size;
import com.irineu.eightpuzzle.model.buscaInformada.CalcularDistanciaManhattan;


import java.util.*;

public class Vertice implements Size {

    private Puzzle puzzle;
    private Vertice vLig[];
    @JsonBackReference
    private List<Vertice> verticesVisitados;
    private boolean visitado;
    private int fa;
    private int fc;
    private int somaFaFc;
    private int tl;

    public Vertice() {
    }

    public Vertice(Puzzle puzzle) {
        this.puzzle = puzzle;
        this.vLig = new Vertice[N];
        this.verticesVisitados = new ArrayList<>();
        this.visitado = false;
        this. fa = 0;
        this.fc = 0;
        this.tl = 0;
    }

    public Vertice(Puzzle puzzle, Vertice[] vLig, List<Vertice> verticesVisitados, boolean visitado, int fa, int fc, int tl) {
        this.puzzle = puzzle;
        this.vLig = vLig;
        this.verticesVisitados = verticesVisitados;
        this.visitado = visitado;
        this.fa = fa;
        this.fc = fc;
        this.tl = tl;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public Vertice[] getvLig() {
        return vLig;
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

    public int getFa() {
        return fa;
    }

    public void setFa(int fa) {
        this.fa = fa;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public int getFaFc() {
        return this.fa + this.fc;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public List<Vertice> getVerticesVisitados() {
        return verticesVisitados;
    }

    public void setVerticesVisitados(List<Vertice> listaVertice) {
        for (Vertice auxVertice: listaVertice ) {
            setVerticeVisitado(auxVertice);
        }
    }

    public void setVerticeVisitado(Vertice vertice) {
        this.verticesVisitados.add(new Vertice(vertice.getPuzzle(), vertice.getvLig(), vertice.getVerticesVisitados(), vertice.getVisitado(), vertice.getFa(), vertice.getFc(), vertice.getTl()));
    }

    public void desenha() {
        var valores = this.puzzle.getValores();
        System.out.println("\n-----------");
        System.out.println("| " + valores.get(0) + "  " + valores.get(3) + "  " +valores.get(6) + " |");
        System.out.println("| " + valores.get(1) + "  " + valores.get(4) + "  " +valores.get(7) + " |");
        System.out.println("| " + valores.get(2) + "  " + valores.get(5) + "  " +valores.get(8) + " |");
        System.out.println("-----------");
    }

    private boolean verificaNovoVertice(Puzzle gerado, List<Vertice> verticesVisitados) {
        int pos = 0;
        boolean naoAchou = true;
        while(pos < verticesVisitados.size() && naoAchou) {
            if(verticesVisitados.get(pos).getPuzzle().getValores().equals(gerado.getValores())) {
                naoAchou = false;
            }
            pos++;
        }
        return naoAchou; // neguei aqui pq se não dentro do laço teria ficar perguntando
        // !naoAchou ou !achou, aqui uso not uma única vez antes de retornar
    }

    public void gerarVertices(List<Vertice> verticesVisitados) {
        Puzzle tempPuzzle;

        tempPuzzle = this.puzzle.moveCima();
        if (tempPuzzle != null && verificaNovoVertice(tempPuzzle, verticesVisitados)) {
            this.vLig[this.tl++] = new Vertice(tempPuzzle);

        }

        tempPuzzle = this.puzzle.moveBaixo();
        if (tempPuzzle != null && verificaNovoVertice(tempPuzzle, verticesVisitados)) {
            this.vLig[this.tl++] = new Vertice(tempPuzzle);
        }

        tempPuzzle = this.puzzle.moveDireita();
        if (tempPuzzle != null && verificaNovoVertice(tempPuzzle, verticesVisitados)) {
            this.vLig[this.tl++] = new Vertice(tempPuzzle);
        }

        tempPuzzle = this.puzzle.moveEsquerda();
        if (tempPuzzle != null && verificaNovoVertice(tempPuzzle, verticesVisitados)) {
            this.vLig[this.tl++] = new Vertice(tempPuzzle);
        }

//        return verticesGerados;
    }

    public void calculaFa(List<Character> objetivo) {
//        this.fa = 0;
        this.fa = new CalcularDistanciaManhattan().calcular(puzzle.getValores(), objetivo);
    }


}
