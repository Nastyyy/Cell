package com.justintunheim;

import com.justintunheim.util.GridPrinter;

// TODO
// Cell searching/indexing is currently un-safe

public class Main {
    private static final int ix = 10;

    private static final int xy = 8;
    private static boolean running = false;

    public static void main(String[] args) {
        Rule rule = new Rule1();
        Run(rule);
    }

    public static void Run(Rule rule) {
        running = true;
        Simulation sim = new Simulation(rule, xy);
        sim.grid.ToggleCell(1,1);

        while(running) {
            if(sim.getEpoch() == ix) break;

            sim.Update();
            sim.Printer.PrintGrid(sim.getEpoch());
        }

        running = false;
    }
}
