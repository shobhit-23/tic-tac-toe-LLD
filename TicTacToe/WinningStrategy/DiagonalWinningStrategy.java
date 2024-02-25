package TicTacToe.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Symbol;

public class DiagonalWinningStrategy implements WinningStrategy{
     Map<Integer,HashMap<Symbol,Integer>> diagonalcount=new HashMap<>();

    @Override
    public boolean checkWinner(Board board ,Move move){
        // | 0 | -> {'X'->0 '0'->1}
        
        int col=move.getCell().getCol();
        int row=move.getCell().getRow();
        int diagonal=row-col;
        Symbol symbol=move.getPlayer().getSymbol();
        
        if(!diagonalcount.containsKey(diagonal))
        {
            diagonalcount.put(diagonal,new HashMap<>());
        }
        HashMap<Symbol,Integer> diagonalMap=diagonalcount.get(diagonal);
        if(!diagonalMap.containsKey(symbol))
        {
            diagonalMap.put(symbol,0);
        }
        diagonalMap.put(symbol,diagonalMap.get(symbol)+1);
        if(diagonalMap.get(symbol)==board.getSize())
        {
            return true;
        }

        diagonal=row+col;
         symbol=move.getPlayer().getSymbol();
        
        if(!diagonalcount.containsKey(diagonal))
        {
            diagonalcount.put(diagonal,new HashMap<>());
        }
        HashMap<Symbol,Integer> diagonalMap1=diagonalcount.get(diagonal);
        if(!diagonalMap1.containsKey(symbol))
        {
            diagonalMap1.put(symbol,0);
        }
        diagonalMap1.put(symbol,diagonalMap1.get(symbol)+1);
        if(diagonalMap1.get(symbol)==board.getSize())
        {
            return true;
        }
        
        return false;
    }
    @Override
    public void handleUndo(Board board, Move move) {
        int col=move.getCell().getCol();
        int row=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();
        
        int diagonal=row-col;
        HashMap<Symbol,Integer> colMap=diagonalcount.get(diagonal);
       
        colMap.put(symbol,colMap.get(symbol)-1);
        // diagonal=row+col;
        // HashMap<Symbol,Integer> colMap1=diagonalcount.get(diagonal);
       
        // colMap1.put(symbol,colMap1.get(symbol)-1);
    }
}
