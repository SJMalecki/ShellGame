package pl.sjmprofil;

import java.util.Collections;

public class Game {

    public void game(String playerName){
        int levelNumber = 1;
        int boxes = 3;

        Player player = new Player(playerName);
        Table table = new Table("level "+ levelNumber, boxes);

        while(true){

            if(player.gameResult(table.choseBox())){
                levelNumber++;
                boxes++;
                table = new Table("level "+ levelNumber, boxes);
            }else{
                //Collections.shuffle(table.getBoxList());
            }

            if(player.getPoints() == 5){
                System.out.println("Congratulations u won !");
                break;
            }

            if(player.getChances() == 0){
                System.out.println(playerName + " statistic: ");
                System.out.println("Approaches " + player.getApproaches());
                System.out.println("Points " + player.getPoints());
                break;
            }else{
                System.out.println("Chances: " + player.getChances());
            }

        }
    }

}
