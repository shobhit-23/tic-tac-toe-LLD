package TicTacToe.models;

public class Symbol {
    private char symbol;
    public Symbol(char symbol) {
        this.symbol = symbol;
        System.out.println("COmes here");
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    
}
