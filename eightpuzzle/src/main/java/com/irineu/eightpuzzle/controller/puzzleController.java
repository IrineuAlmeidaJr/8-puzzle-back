package com.irineu.eightpuzzle.controller;

import com.irineu.eightpuzzle.model.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class puzzleController {

    @PostMapping("/buscarsolucao")
    public List<Vertice> buscarSolucao(@RequestBody EntradaDados dados) {

        List<Vertice> lista = new ArrayList<>();

        if (dados.getTipoBusca() == 1) {
            Grafo grafo = new Grafo(new Puzzle(dados.getEstados()));
            BuscaProfundidade buscaProfundidade = new BuscaProfundidade();
            buscaProfundidade.buscar(grafo, dados.getObjetivo());
            lista = buscaProfundidade.getVerticesGerados();
        }

        return lista;
    }


}
