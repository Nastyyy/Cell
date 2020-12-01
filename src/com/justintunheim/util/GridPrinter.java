package com.justintunheim.util;

import com.justintunheim.Cell;
import com.justintunheim.Grid;

import java.util.List;

public class GridPrinter {
    private Grid grid;

    public GridPrinter(Grid grid) {
        this.grid = grid;
    }

    public String barrierString(int i) {
        String fourth = "*".repeat(grid.GetX()*4/4);
        return "\n" + fourth + " " + epochString(i) + " " + fourth + fourth;
    }

    public String epochString(int i) {
        String offset;
        int baseOffset = 3;

        // 10   |
        // 100  |
        // 1000 |

        if(i < 99) offset = " ".repeat(baseOffset);
        else if(i < 999) offset = " ".repeat(baseOffset-1);
        else if(i < 9999) offset = " ".repeat(baseOffset-2);
        else offset = "";

        return String.valueOf(i) + offset;
    }

    public void PrintGrid(int i) {
        System.out.println(barrierString(i));
        List<List<Cell>> rows = grid.GetRows();
        for(List<Cell> row : rows) {
            System.out.println(row(row));
        }
    }
    
    private String row(List<Cell> row) {
        StringBuilder output = new StringBuilder();
        for(Cell cell: row)  {
            output.append(cell(cell));
        }

        return output.toString();
    }

    private String cell(Cell cell) {
        if(cell.IsOn()) return "ON  ";
        return "OFF ";
    }
    
    public void PrintXandY() {
        PrintX();
        PrintY();
    }

    public void PrintX() {
        System.out.println("grid.x = " + grid.GetX());
    }
    public void PrintY() {
        System.out.println("grid.y = " + grid.GetY());
    }
}
