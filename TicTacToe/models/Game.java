package TicTacToe.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Exceptions.TooManyBotsException;
import TicTacToe.Exceptions.duplicateSymbolException;
import TicTacToe.WinningStrategy.WinningStrategy;
import TicTacToe.enums.CellState;
import TicTacToe.enums.GameState;
import TicTacToe.enums.PlayerType;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private GameState gameState;
    private List<Move> moves;
    private Player winner;
 
    private Game(int dimension,List<Player>players,List<WinningStrategy>winningStrategies){
        this.board=new Board(dimension);
        this.moves=new ArrayList<>();
        this.players=players;
        this.nextMovePlayerIndex=0;
        this.winningStrategies=winningStrategies;
        this.winner=null;
        this.gameState=GameState.IN_PROGRESS;

    }
    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        
        public Game build() throws TooManyBotsException,InvalidPlayerCountException,duplicateSymbolException{
            //validations

            //Bot count 
            validateBotCount();  
            // player
            validatePlayerCount();
            //no duplicate symbols 
            validDuplicateSymbols();

            return new Game(this.dimension,this.players,this.winningStrategies);
        }

        private void validateBotCount() throws TooManyBotsException{
            int botCount=0;
            for(Player player:players)
            {
                if(player.getPlayerType().equals(PlayerType.BOT))
                {
                    botCount++;
                }
            }
            if(botCount>1)
            {
                throw new TooManyBotsException();
            }
        }

        private void validDuplicateSymbols() throws duplicateSymbolException{
            HashSet<Symbol>hs=new HashSet<>();
            for(Player player:players)
            {
                if(hs.contains(player.getSymbol()))
                {
                    throw new duplicateSymbolException();
                }
                hs.add(player.getSymbol());
            }
            
        }
        private void validatePlayerCount() throws  InvalidPlayerCountException{
                if(players.size()>dimension-1)
                    throw new InvalidPlayerCountException();
        }
        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
    }

    public static  Builder getBuilder(){
        return new Builder();
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }
    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }
    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }
    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public Player getPlayer() {
        return winner;
    }
    public void setPlayer(Player player) {
        this.winner = player;
    }
    public void printBoard(){
        board.printBoard();
    }
    public void makeMove(Board board){
        // current player
        Player currentPlayer =players.get(nextMovePlayerIndex);
        System.out.println("It is "+currentPlayer.getName()+"'s Move");

        // make move

        Move move=currentPlayer.makeMove(board);
        
        if(!validateMove(move))
        {
            System.out.println("Please try again.");
            return;
        }

        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        Cell cellTobeUpdated=board.getGrid().get(row).get(col);
        cellTobeUpdated.setPlayer(currentPlayer);
        cellTobeUpdated.setCellState(CellState.FILLED);
    

        // add it to move list
        Move finalMoveObject =new Move(cellTobeUpdated,currentPlayer);
        moves.add(finalMoveObject);

        //update nextPlayerIndex
        nextMovePlayerIndex+=1;
        //System.out.println(nextMovePlayerIndex+" "+players.size());
        nextMovePlayerIndex%=players.size();

        // update cell and board
        // update game state and check winner
        if(checkWinner(board,finalMoveObject))
        {
            //WInner
            gameState=GameState.WON;
            winner=currentPlayer;
        }
        else if(moves.size()==board.getSize()*board.getSize()){
            //Draw
            gameState=GameState.DRAW;
        }
    }
    private boolean checkWinner(Board board,Move move){
        for(WinningStrategy winningStrategy:winningStrategies){
            if(winningStrategy.checkWinner(board,move))
            return true;
        }
        return false;
    }
    private boolean validateMove(Move move){
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        if(row>=board.getSize() || col>=board.getSize()){
            return false;
        }
        if(board.getGrid().get(row).get(col).equals(CellState.EMPTY)){
            return false;
      
        }
        return true;
    }
    public void handleUndo(){
         // one move should be there
        if(moves.size()==0)
        {
            System.out.println("No moves has been done yet.");
            return;
        }
        
       
         // get and remove last move
         Move move=moves.get(moves.size()-1);
         moves.remove(move);

         // update cell state
         Cell cell=move.getCell();
         cell.setCellState(CellState.EMPTY);
         cell.setPlayer(null);
         //update nextPlayerState

         nextMovePlayerIndex-=1;
         nextMovePlayerIndex=(nextMovePlayerIndex+players.size())%players.size();

         //Revert Winning Strategy move

         for(WinningStrategy winningStrategy:winningStrategies){
            winningStrategy.handleUndo(board, move);
         }
    }
}
