package TicTacToe.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Symbol;

public class ColumnWinningStrategy implements WinningStrategy{
 
    Map<Integer,HashMap<Symbol,Integer>> colcount=new HashMap<>();

    @Override
    public boolean checkWinner(Board board ,Move move){
        // | 0 | -> {'X'->0 '0'->1}
        
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();
        
        if(!colcount.containsKey(col))
        {
            colcount.put(col,new HashMap<>());
        }
        HashMap<Symbol,Integer> colMap=colcount.get(col);
        if(!colMap.containsKey(symbol))
        {
            colMap.put(symbol,0);
        }
        colMap.put(symbol,colMap.get(symbol)+1);
        if(colMap.get(symbol)==board.getSize())
        {
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();

        HashMap<Symbol,Integer> colMap=colcount.get(col);
       
        colMap.put(symbol,colMap.get(symbol)-1);
       
    }
    
}
