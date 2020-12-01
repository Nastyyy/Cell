package com.justintunheim;

public interface Rule {
    void visitCell(Cell cell);
}

class IdentityRule implements Rule {
    public void visitCell(Cell cell) {}
}

class Rule1 implements Rule {
   public void visitCell(Cell cell)  {
       if(cell.IsOn() && !cell.right.IsOn()) {
          cell.right.Toggle();
       }
   }
}

