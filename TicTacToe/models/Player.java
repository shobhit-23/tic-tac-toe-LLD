package TicTacToe.models;

import java.util.Scanner;

import TicTacToe.enums.PlayerType;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner sc=new Scanner(System.in);
    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public Move makeMove(Board board){
        System.out.println("Enter the row :");
        int row=sc.nextInt();

        System.out.println("Enter the column: ");
        int col=sc.nextInt();
      
        Move move=new Move(new Cell(row, col),this);

        return move;
    }
}
