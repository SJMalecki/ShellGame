package pl.sjmprofil;

public class Player {

    private String playerName;
    private int points = 0;
    private int approaches = 0;
    private int chances = 3;

    public Player(String playerName){
        this.playerName = playerName;
    }

    public boolean gameResult(boolean result){
        approaches++;
        if(result){
            this.points++;
            bonus();
            return true;
        }else if(lostChance()){
            return false;
        }
        return false;
    }

    public boolean addChance(){
        this.chances += 1;
        System.out.println("+ Chance");
        return true;
    }

    public void bonus(){
        if(points > 0 && points%2 == 0 || points > 2){
            addChance();
        }
    }

    public boolean lostChance(){
        this.chances -= 1;
        if(this.chances == 0){
            System.out.println("Game Over");
            return false;
        }else {
            return true;
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPoints() {
        return points;
    }

    public int getApproaches() {
        return approaches;
    }

    public int getChances() {
        return chances;
    }
}
