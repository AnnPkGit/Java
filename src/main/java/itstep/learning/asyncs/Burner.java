package itstep.learning.asyncs;

import itstep.learning.ConsoleColors;

public class Burner {
    private int number;
    private boolean isBusy;
    public Burner(int num) {
        number = num;
        isBusy = false;
    }

    public boolean isBusy(){
        return isBusy;
    }

    public void setBusy(){
        isBusy = true;
    }

    public void setFree(String color){
        System.out.println( "\uD83D\uDD25" + "\uD83D\uDD13" + color + "Комфорка №" + number + " свободна" + ConsoleColors.RESET) ;
        isBusy = false;
    }

    public void HeatForTime(int ms, String whatToHeat, String color) throws InterruptedException {
        System.out.println( "\uD83D\uDD25" + "\uD83D\uDD10" + color + "Комфорка №" + number + " занята [" + whatToHeat + "]" + ConsoleColors.RESET) ;
        Thread.sleep( ms ) ;
    }
}
