package com.irineu.eightpuzzle.controller;

import com.irineu.eightpuzzle.model.EntradaDados;
import com.irineu.eightpuzzle.model.Grafo;
import com.irineu.eightpuzzle.model.Puzzle;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class puzzleController {

    @PostMapping("/buscarsolucao")
    public Grafo buscarSolucao(@RequestBody EntradaDados dados) {
        Grafo grafo = new Grafo();
        Puzzle puzzle = new Puzzle();
        if (dados.getTipoBusca() != 0) {
            var lista = dados.getEstados();
            lista.set(0, '0');
            lista.set(1, '0');
            lista.set(2, '0');
            puzzle.setValores(lista);
            for(int i=0; i < 10; i++)
                grafo.getVertices().add(puzzle);
        }
        return grafo;
    }


}
