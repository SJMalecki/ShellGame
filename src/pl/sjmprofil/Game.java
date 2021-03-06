package pl.sjmprofil;

import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    public void game(String playerName) {
        int levelNumber = 1;
        int boxes = 3;
        boolean endInformationPopUp = false;

        System.out.println("Only one box is not empty, guess which by using letters,\nYou have 3 chances, good luck !");
        Player player = new Player(playerName);
        Table table = new Table("level " + levelNumber, boxes);

        while (true) {
            if (player.getPoints() == 3 && !endInformationPopUp) {
                System.out.println("\nCongratulations u won !\nyou can continue playing\npress enter to continue");
                scanner.nextLine();
                endInformationPopUp = true;
            }

            if (player.gameResult(table.choseBox())) {
                levelNumber++;
                boxes++;
                table = new Table("level " + levelNumber, boxes);
            }

            if (player.getChances() == 0) {
                System.out.println(playerName + " statistic: ");
                System.out.println("Approaches " + player.getApproaches());
                System.out.println("Points " + player.getPoints());
                System.out.println("Play once more ? Y/N");
                if(scanner.nextLine().equalsIgnoreCase("Y")){
                    System.out.println("New game");
                    player.resetChance();
                    game(playerName);
                }else{
                    System.out.println("Thanks for playing");
                    System.exit(0);
                }
            } else {
                System.out.println("Chances: " + player.getChances());
            }
        }
    }

}
