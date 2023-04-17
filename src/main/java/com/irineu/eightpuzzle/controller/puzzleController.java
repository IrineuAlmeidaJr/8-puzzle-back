package com.irineu.eightpuzzle.controller;

import com.irineu.eightpuzzle.model.*;
import com.irineu.eightpuzzle.model.buscaInformada.BuscaA;
import com.irineu.eightpuzzle.model.buscaNaoInformada.BuscaLargura;
import com.irineu.eightpuzzle.model.buscaNaoInformada.BuscaProfundidade;
import com.irineu.eightpuzzle.model.formatoDados.EntradaDados;
import com.irineu.eightpuzzle.model.formatoDados.SaidaDados;
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

                    System.out.println("-----------\n- - - DFS - - -");
//                    for (Vertice vertice: solucao) {
//                        vertice.desenha();
//                    }
                    System.out.println("TEMPO - > " + buscaProfundidade.getTempoGasto() + "ms");
                    saidaDados = new SaidaDados("DFS", verticesVisitados, solucao, buscaProfundidade.getTempoGasto());
                    break;
            case 2: BuscaLargura buscaLargura = new BuscaLargura();
                    buscaLargura.buscar(grafo, dados.getObjetivo());
                    solucao = buscaLargura.getSolucao();
                    verticesVisitados = buscaLargura.getVerticesVisitados();

                    System.out.println("-----------\n- - - BFS - - -");
//                    for (Vertice vertice: solucao) {
//                        vertice.desenha();
//                    }
                    System.out.println("TEMPO - > " + buscaLargura.getTempoGasto() + "ms");
                    System.out.println("MOVIMENTOS -> " + buscaLargura.getVerticesVisitados().size());

                    saidaDados = new SaidaDados("BFS", verticesVisitados, solucao, buscaLargura.getTempoGasto());

                    break;
            case 3: BuscaA buscaA = new BuscaA();
                    buscaA.buscar(grafo, dados.getObjetivo());
                    solucao = buscaA.getSolucao();
                    verticesVisitados = buscaA.getVerticesVisitados();

                    System.out.println("\n- - - - - - - - - - -" +
                            "\n- - - Busca A* - - -");
//                    for (Vertice vertice: solucao) {
//                        vertice.desenha();
//                    }
                    System.out.println("TEMPO - > " + buscaA.getTempoGasto() + "ms");
                    System.out.println("MOVIMENTOS -> " + buscaA.getVerticesVisitados().size());
                    saidaDados = new SaidaDados("A*", verticesVisitados, solucao, buscaA.getTempoGasto());
                    break;
        }
        System.out.println();
        System.out.println("\n- - - FIM - - - \n");
        return saidaDados;
    }


}