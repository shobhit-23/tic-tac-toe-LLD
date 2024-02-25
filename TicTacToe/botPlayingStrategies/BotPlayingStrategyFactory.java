package TicTacToe.botPlayingStrategies;

import TicTacToe.enums.DifficultyLevel;

public class BotPlayingStrategyFactory
 {

    public static BotPlayingStrategy getBotPlayingStrategyByDifficultyLevel(DifficultyLevel difficultyLevel){
        if(DifficultyLevel.EASY.equals(difficultyLevel)){
            return new EasyBotPlayingStrategy();
        }
        return null;
    } 
}
