package TicTacToe.Contollers;

import java.util.List;

import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Exceptions.TooManyBotsException;
import TicTacToe.Exceptions.duplicateSymbolException;
import TicTacToe.WinningStrategy.WinningStrategy;
import TicTacToe.enums.GameState;
import TicTacToe.models.Game;
import TicTacToe.models.Player;

public class GameController {
    //1. Create a new game
    //2.Display the board 
    //check winner and while game state is in progress
        //Make a move
        //Display updated board
    // check game state and 
        // if draw-> handle draw
        // if winner-> display winner
     // handle pause   

    
     public Game startGame(int size,List<Player>players,List<WinningStrategy>winningStrategy) throws duplicateSymbolException,InvalidPlayerCountException,TooManyBotsException{
           
           //validations
           //Builder pattern

          // return new Game();
          return Game.getBuilder()
                  .setPlayers(players)
                  .setDimension(size)
                  .setWinningStrategies(winningStrategy)
                  .build();
     }
     public void displayBoard(Game game){
         game.getBoard().printBoard();   
     }
     public void makeMove(Game game){
        // make a move on that game's board
        game.makeMove(game.getBoard());
     }
     public GameState checkState(Game game){
        return game.getGameState();
     }
     public Player getWinner(Game game){
        return game.getPlayer();
     }
     public void undo(Game game){
         game.handleUndo();
     }
}
