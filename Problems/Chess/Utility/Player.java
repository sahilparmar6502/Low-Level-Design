package Utility;

public class Player{

    private String playerName;
    private boolean whitePlayer;

    public Player(String playerName,boolean whitePlayer){
        this.playerName = playerName;
        this.whitePlayer = whitePlayer;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public boolean isWhitePlayer(){
        return this.whitePlayer;
    }
};