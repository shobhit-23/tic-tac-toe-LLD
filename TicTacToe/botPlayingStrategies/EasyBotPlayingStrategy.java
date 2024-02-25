package TicTacToe.botPlayingStrategies;

import java.util.List;

import TicTacToe.enums.CellState;
import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makMove(Board board){
        for(List<Cell> row:board.getGrid())
        {
            for(Cell cell:row)
            {
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(cell,null);
                }
            }
        }
        return null;
    }



    
}
