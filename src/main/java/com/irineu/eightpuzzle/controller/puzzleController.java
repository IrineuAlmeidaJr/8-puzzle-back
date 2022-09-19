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
        Grafo grafo = new Grafo(new Puzzle(dados.getEstados()));
        List<Vertice> lista = new ArrayList<>();

        switch (dados.getTipoBusca()) {
            case 1: BuscaProfundidade buscaProfundidade = new BuscaProfundidade();
                    buscaProfundidade.buscar(grafo, dados.getObjetivo());
//                    lista = buscaProfundidade.getVerticesGerados();
                    lista = buscaProfundidade.getVerticesVisitados();
                    break;
            case 2: BuscaLargura buscaLargura = new BuscaLargura();
                    buscaLargura.buscar(grafo, dados.getObjetivo());
                    lista = buscaLargura.getVerticesVisitados();
                    break;
        }

        return lista;
    }


}
