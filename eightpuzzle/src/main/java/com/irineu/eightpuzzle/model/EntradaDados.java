package com.irineu.eightpuzzle.model;

import java.util.List;

public class EntradaDados {

    private int tipoBusca;
    private List<Character> estados;

    public EntradaDados() { }

    public EntradaDados(int tipoBusca, List<Character> entradaPuzzle) {
        this.tipoBusca = tipoBusca;
        this.estados = entradaPuzzle;
    }

    public int getTipoBusca() {
        return tipoBusca;
    }

    public List<Character> getEstados() {
        return estados;
    }
}
