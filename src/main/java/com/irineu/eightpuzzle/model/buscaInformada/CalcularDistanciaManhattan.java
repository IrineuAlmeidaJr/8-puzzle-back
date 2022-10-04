package com.irineu.eightpuzzle.model.buscaInformada;

import com.irineu.eightpuzzle.model.Vertice;

import java.util.List;

public class CalcularDistanciaManhattan {

    public int calcular(List<Character> estadoFinal, List<Character> estadoAtual) {
        int distanciaManhattan = 0;
        int estFinal, estAtual;
        for(int i=0; i<9; i++){
            estAtual= estadoFinal.get(i);
            estFinal = estadoAtual.get(i);
            distanciaManhattan += Math.abs(estAtual - estFinal) ;
        }
        return distanciaManhattan;
    }

}
