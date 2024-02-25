package TicTacToe.botPlayingStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public interface BotPlayingStrategy{
    public Move makMove(Board board);
}
