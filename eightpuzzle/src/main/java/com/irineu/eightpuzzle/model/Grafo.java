package com.irineu.eightpuzzle.model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private List<Puzzle> vertices;

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public List<Puzzle> getVertices() {
        return vertices;
    }

    public void setVertices(List<Puzzle> vertices) {
        this.vertices = vertices;
    }
}
