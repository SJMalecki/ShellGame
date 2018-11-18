package pl.sjmprofil;

public class Box implements Comparable<Box> {

    private String boxMark;
    private boolean winBox = false;

    public Box(String boxMark){
        this.boxMark = boxMark;
    }

    public String getBoxMark(){
        return boxMark;
    }

    public boolean isWinBox() {
        return winBox;
    }

    public boolean setWinBox(){
        if(!this.winBox){
            System.out.println("Win box set");
            this.winBox = true;
            return true;
        }else{
            System.out.println("Win box already set");
            return false;
        }
    }

    @Override
    public int compareTo(Box box) {
        return this.boxMark.compareToIgnoreCase(box.getBoxMark());
    }
}
