package com.irineu.eightpuzzle.model;

import java.util.List;

public class Puzzle {

    private List<Character> valores;

    public Puzzle() { }

    public Puzzle(List<Character> valores) {
        this.valores = valores;
    }

    public List<Character> getValores() {
        return valores;
    }

    public void setValores(List<Character> valores) {
        this.valores = valores;
    }

    // Fazer aqui o mover Up, Down, Left, Right
}
