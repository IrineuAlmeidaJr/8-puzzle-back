package com.irineu.eightpuzzle.model.formatoDados;

import java.util.List;

public class EntradaDados {

    private int tipoBusca;
    private List<Character> estados;
    private List<Character> objetivo;


    public EntradaDados() { }

    public EntradaDados(int tipoBusca, List<Character> entradaPuzzle, List<Character> objetivo) {
        this.tipoBusca = tipoBusca;
        this.estados = entradaPuzzle;
        this.objetivo = objetivo;
    }

    public int getTipoBusca() {
        return tipoBusca;
    }

    public List<Character> getEstados() {
        return estados;
    }

    public List<Character> getObjetivo() {
        return objetivo;
    }
}
