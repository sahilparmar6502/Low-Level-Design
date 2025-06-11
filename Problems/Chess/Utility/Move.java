package Utility;

public class Move{

    private Cell startCell;
    private Cell endCell;

    public Move(Cell startCell,Cell endCell){
        this.startCell = startCell;
        this.endCell = endCell;
    }

    public boolean isValid(){
        if(this.endCell.getPiece() == null) return true;
        return !(this.startCell.getPiece().isWhite() == this.endCell.getPiece().isWhite());
    }

    public Cell getStartCell(){
        return this.startCell;
    }

    public Cell getEndCell(){
        return this.endCell;
    }
};