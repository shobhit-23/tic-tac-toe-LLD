package TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.Scanner;

import TicTacToe.Contollers.GameController;
import TicTacToe.Exceptions.TooManyBotsException;
import TicTacToe.Exceptions.duplicateSymbolException;
import TicTacToe.WinningStrategy.ColumnWinningStrategy;
import TicTacToe.WinningStrategy.DiagonalWinningStrategy;
import TicTacToe.WinningStrategy.RowWinningStrategy;
import TicTacToe.WinningStrategy.WinningStrategy;
import TicTacToe.enums.DifficultyLevel;
import TicTacToe.enums.GameState;
import TicTacToe.enums.PlayerType;
import TicTacToe.models.BotPlayer;
import TicTacToe.models.Game;
import TicTacToe.models.Player;
import TicTacToe.models.Symbol;

public class Client {
    public static void main(String[] args) throws Exception {
        // client->contoller->models/service
        GameController gameController=new GameController();
        System.out.println("Game Starting...");
        Scanner scanner=new Scanner(System.in);

        Game game=null;
        try{
            //client inputs
            //size,players,winning strategy

            int dimension=3;
 
            List<Player> players=new ArrayList<>();
            players.add(new Player(1,"Shyam",new Symbol('X'),PlayerType.HUMAN));
            players.add(new BotPlayer(2,"BOT",new Symbol('0'),PlayerType.BOT,DifficultyLevel.EASY));

            List<WinningStrategy> winningStrategyList=Arrays.asList(new RowWinningStrategy(),new ColumnWinningStrategy(),new DiagonalWinningStrategy());

            game=gameController.startGame(dimension, players,winningStrategyList);

            gameController.displayBoard(game); //stateless

            while (gameController.checkState(game).equals(GameState.IN_PROGRESS)) {
                gameController.makeMove(game);
                gameController.displayBoard(game);
                
                System.out.println("Do you want to UNDO (y/n)?");
                String undoAns=scanner.next();

                if(undoAns.equalsIgnoreCase("Y")){
                    gameController.undo(game);
                    gameController.displayBoard(game);
                }
            }
            System.out.println("THe game is finished");
            if(gameController.checkState(game).equals(GameState.WON)){
                System.out.println("The winnier is "+gameController.getWinner(game).getName());
            }
            else if(gameController.checkState(game).equals(GameState.DRAW)){
                System.out.println("Game has been ended in draw.");
            }
        }
        catch(TooManyBotsException e){
            System.out.println(e);
        }
        catch(DuplicateFormatFlagsException e){
            System.out.println(e);
        }
        catch(duplicateSymbolException e){
            System.out.println(e);
        }

        
    }
}
