package com.justintunheim;

import com.justintunheim.util.GridPrinter;

public class Simulation {
    Rule rule;
    Grid grid;
    public GridPrinter Printer;
    public GridDrawer Drawer;
    private int epoch = 0;

    Simulation(Rule rule, int x, int y) {
        this.rule = rule;
        this.grid = new Grid(x, y);
        Printer = new GridPrinter(grid);
        Drawer = new GridDrawer(grid);
    }

    Simulation(Rule rule, int xy) { this(rule, xy, xy); }

    Simulation(Rule rule) {
        this(rule, 16, 16);
    }

    void Update() {
        epoch++;
        grid.Update(rule);
    }

    public int getEpoch() {
        return epoch;
    }
}
