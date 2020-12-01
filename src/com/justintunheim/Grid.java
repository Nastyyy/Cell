package com.justintunheim;


import java.util.ArrayList;
import java.util.List;

public class Grid {
    private static final int defaultXY = 128;

    private int x;
    private int y;

    private List<List<Cell>> cells = new ArrayList<List<Cell>>();

    Grid() {
        this(defaultXY);
    }

    Grid(int xy) {
        this(xy, xy);
    }

    Grid(int x, int y) {
        SetXY(x, y);
        GenerateCells();
    }

    public void Update(Rule rule) {
        for(List<Cell> row: cells) {
            for(Cell cell : row) {
                cell.Update(rule);
            }
        }
    }

    public void ToggleCell(int x, int y) {
        Cell cell = getCell(x, y);
        cell.Toggle();
    }

    private void GenerateCells() {
        // Generate rows using y value
        for(int y=0; y < this.y; y++) {
            ArrayList<Cell> row = new ArrayList<Cell>();

            // Generate columns using x value
            for(int x=0; x < this.x; x++) {
               Cell cell = new Cell(x+y*10);

               // Make sure we have an up
               if(y != 0) {
                   cell.SetUp(getCell(x, y-1));
               }
               // Make sure we have a left
               if(x != 0) {
                   cell.SetLeft(row.get(x-1));
               }

               row.add(cell);
            }

            cells.add(row);
        }
    }

    private void LinkCell(int x, int y) {
        Cell targetCell = getCell(x, y);
        if(x == 0 || y == 0) {
            return;
        } else if(x == this.x || y == this.y) {
            // {{{
            return;
        }
    }


    public void SetXY(int x, int y) {
       this.x = x;
       this.y = y;
    }

    private Cell getCell(int x, int y) { return this.cells.get(y).get(x); }
    public List<List<Cell>> GetRows() { return this.cells; }
    public int GetX() {
        return this.x;
    }
    public int GetY() {
        return this.y;
    }
}
