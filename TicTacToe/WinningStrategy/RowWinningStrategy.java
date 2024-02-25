package TicTacToe.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Symbol;

public class RowWinningStrategy implements WinningStrategy{
    Map<Integer,HashMap<Symbol,Integer>> rowcount=new HashMap<>();

    @Override
    public boolean checkWinner(Board board ,Move move){
        // | 0 | -> {'X'->0 '0'->1}
        
        int row=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();
        
        if(!rowcount.containsKey(row))
        {
            rowcount.put(row,new HashMap<>());
        }
        HashMap<Symbol,Integer> rowMap=rowcount.get(row);
        if(!rowMap.containsKey(symbol))
        {
            rowMap.put(symbol,0);
        }
        rowMap.put(symbol,rowMap.get(symbol)+1);
        if(rowMap.get(symbol)==board.getSize())
        {
            return true;
        }
        
        return false;
}
@Override
    public void handleUndo(Board board, Move move) {
        int col=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();

        HashMap<Symbol,Integer> rowMap=rowcount.get(col);
       
        rowMap.put(symbol,rowMap.get(symbol)-1);
       
    }
}
