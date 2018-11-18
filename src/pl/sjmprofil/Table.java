package pl.sjmprofil;

import java.util.*;

public class Table {

    private String tableName;
    private List<Box> boxList = new ArrayList<>();

    public Table(String tableName, int howManyBoxes){
        this.tableName = tableName;

        int maxBoxes = 'A' + (howManyBoxes -1);
        for(char boxLetter = 'A'; boxLetter <= maxBoxes; boxLetter++){
            Box box = new Box(boxLetter + "");
            boxList.add(box);
        }

        Random random = new Random();
        boxList.get(random.nextInt(howManyBoxes)).setWinBox();
    }

    public void printBoxList(){
        for(Box box : boxList){
            System.out.print(box.getBoxMark() + " ");
        }
    }

    public boolean choseBox(){
        printBoxList();
        System.out.println("\nSelect box: ");
        Scanner scanner = new Scanner(System.in);
        String playerChoice = scanner.next();

        Box requestedBox = new Box(playerChoice);
        int foundBox = Collections.binarySearch(boxList, requestedBox, null);
        if(foundBox >= 0){
            if(boxList.get(foundBox).isWinBox()){
                System.out.println("Correct");
                return true;
            }else{
                System.out.println("Wrong - box is empty");
                return false;
            }
        }else{
            System.out.println("Invalid choice - try again");
            choseBox();
        }
        return false;
    }
}
