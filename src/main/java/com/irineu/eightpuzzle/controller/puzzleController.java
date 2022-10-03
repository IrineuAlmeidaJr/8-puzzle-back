package com.irineu.eightpuzzle.controller;

import com.irineu.eightpuzzle.model.*;
import com.irineu.eightpuzzle.model.buscasCegas.BuscaLargura;
import com.irineu.eightpuzzle.model.buscasCegas.BuscaProfundidade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class puzzleController {

    @PostMapping("/buscarsolucao")
    public SaidaDados buscarSolucao(@RequestBody EntradaDados dados) {
        Grafo grafo = new Grafo(new Puzzle(dados.getEstados()));
        List<Vertice> solucao = new ArrayList<>();
        List<Vertice> verticesVisitados = new ArrayList<>();
        SaidaDados saidaDados = new SaidaDados();

        switch (dados.getTipoBusca()) {
            case 1: BuscaProfundidade buscaProfundidade = new BuscaProfundidade();
                buscaProfundidade.buscar(grafo, dados.getObjetivo());
                verticesVisitados = buscaProfundidade.getVerticesVisitados();
                solucao = buscaProfundidade.getSolucao();

                for (Vertice vertice: solucao) {
                    vertice.desenha();
                }
                System.out.println("TEMPO - > " + buscaProfundidade.getTempoGasto() + "ms");
                saidaDados = new SaidaDados(verticesVisitados, solucao, buscaProfundidade.getTempoGasto());
                break;
            case 2: BuscaLargura buscaLargura = new BuscaLargura();
                buscaLargura.buscar(grafo, dados.getObjetivo());
                solucao = buscaLargura.getSolucao();
                verticesVisitados = buscaLargura.getVerticesVisitados();

                for (Vertice vertice: solucao) {
                    vertice.desenha();
                }
                System.out.println("TEMPO - > " + buscaLargura.getTempoGasto() + "ms");
                saidaDados = new SaidaDados(verticesVisitados, solucao, buscaLargura.getTempoGasto());

                break;
        }
        System.out.println();
        return saidaDados;
    }


}