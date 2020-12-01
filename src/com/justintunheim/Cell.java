package com.justintunheim;

public class Cell {
    private double state;
    protected Cell left;
    protected Cell right;
    protected Cell up;
    protected Cell down;
    public int ID;

    Cell(int id) {
        ID = id;
        state = 0.0;
    }

    public void Update(Rule rule) {
        rule.visitCell(this);
    }

    //
    // The rules for setting up, down, left, right links is as follows:
    // If you set a left you also set a right
    // If you set a up you also set a down
    // Edge cases are handled manually by the grid

    protected void SetLeft(Cell cell) {
        this.left = cell;
        cell.right = this;
    }

    protected void SetUp(Cell cell) {
        this.up = cell;
        cell.down = cell;
    }

    public Cell GetLeft() {
        return left;
    }
    public Cell GetRight() {
        return right;
    }
    public Cell GetUp() {
        return up;
    }
    public Cell GetDown() {
        return down;
    }

    public double Toggle() {
        if(!IsOn()) return On();
        return Off();
    }

    public double On() { state = 1.0; return state; };
    public double Off() { state = 0.0; return state; };

    public boolean IsOn() { return state == 1.0; };
}
