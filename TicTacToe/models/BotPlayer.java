package TicTacToe.models;


import TicTacToe.botPlayingStrategies.BotPlayingStrategy;
import TicTacToe.botPlayingStrategies.BotPlayingStrategyFactory;
import TicTacToe.enums.DifficultyLevel;
import TicTacToe.enums.PlayerType;

public class BotPlayer extends Player{
    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(int id, String name, Symbol symbol, PlayerType playerType,DifficultyLevel difficultyLevel) {
        super(id,name,symbol,playerType);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy=BotPlayingStrategyFactory.getBotPlayingStrategyByDifficultyLevel(difficultyLevel);
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }
    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    public Move makeMove(Board board){
        Move move=botPlayingStrategy.makMove(board);
        move.setPlayer(this);
        return move;  
    }
}
