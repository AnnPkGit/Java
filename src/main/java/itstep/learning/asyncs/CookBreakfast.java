package itstep.learning.asyncs;

import itstep.learning.ConsoleColors;

public class CookBreakfast {
    public CookBreakfast() {
        this.burner1 = new Burner(1);
        this.burner2 = new Burner(2);
        threadsCount = 3;
    }

    private Burner burner1;
    private Burner burner2;

    private int threadsCount;

    private final Object locker = new Object() ;

    public void run(){
        new Thread(() -> {
            try {
                makeTea();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start() ;
        new Thread(() -> {
            try {
                makeToasts();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start() ;
        new Thread(() -> {
            try {
                makeFriedEggs();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start() ;
    }

    private void makeTea() throws InterruptedException {
        boolean waterIsHeated = false;
        Burner freeBurner = null;
        System.out.println(ConsoleColors.PURPLE + "Начинаю готовить чай" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "Достаю чайник" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "Наливаю в чайник воды" + ConsoleColors.RESET);

        while (!waterIsHeated) {
            synchronized (locker) {
                if (!burner1.isBusy()) {
                    burner1.setBusy();
                    freeBurner = burner1;
                }
            }

            if (freeBurner != null) {
                freeBurner.HeatForTime(1000, "чай", ConsoleColors.PURPLE);
                waterIsHeated = true;
            }

            if (!waterIsHeated) {
                synchronized (locker) {
                    if (!burner2.isBusy()) {
                        burner2.setBusy();
                        freeBurner = burner2;
                    }
                }
                if (freeBurner != null) {
                    freeBurner.HeatForTime(1000, "чай", ConsoleColors.PURPLE);
                    waterIsHeated = true;
                } else {
                    Thread.sleep(10);
                }
            }
        }

        synchronized (locker) {
            freeBurner.setFree(ConsoleColors.PURPLE);
        }

        System.out.println(ConsoleColors.PURPLE + "Ставлю чашки" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "Наливаю воду" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "Кидаю в воду пакетик чая" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "Жду пока произойдет дифузия" + ConsoleColors.RESET);
        Thread.sleep(10);
        System.out.println(ConsoleColors.PURPLE + "[чай]" + ConsoleColors.RESET + ConsoleColors.GREEN + " ГОТОВ" + ConsoleColors.RESET);

        synchronized (locker) {
            threadsCount -= 1;
            if(threadsCount == 0) finish();
        }
    }

    private void makeToasts() throws InterruptedException {
        boolean toastsFried = false;
        Burner freeBurner = null;
        System.out.println( ConsoleColors.BLUE + "Начинаю готовить тосты" + ConsoleColors.RESET) ;
        System.out.println( ConsoleColors.BLUE + "Режу хлеб" + ConsoleColors.RESET) ;

        while(!toastsFried) {
            synchronized (locker) {
                if (!burner1.isBusy()) {
                    burner1.setBusy();
                    freeBurner = burner1;
                }
            }

            if(freeBurner != null){
                freeBurner.HeatForTime(1000, "тосты", ConsoleColors.BLUE);
                toastsFried = true;
            }

            if(!toastsFried) {
                synchronized (locker) {
                    if (!burner2.isBusy()) {
                        burner2.setBusy();
                        freeBurner = burner2;
                    }
                }
                if(freeBurner != null){
                    freeBurner.HeatForTime(1000, "тосты", ConsoleColors.BLUE);
                    toastsFried = true;
                }
                else {
                    Thread.sleep(10);
                }
            }
        }

        synchronized (locker) {
            freeBurner.setFree( ConsoleColors.BLUE);
        }

        System.out.println( ConsoleColors.BLUE + "Достаю хлеб со сковородки" + ConsoleColors.RESET) ;
        System.out.println( ConsoleColors.BLUE + "Бросаю тосты на тарелку" + ConsoleColors.RESET) ;
        System.out.println( ConsoleColors.BLUE   + "[тосты]" + ConsoleColors.RESET + ConsoleColors.GREEN + " ГОТОВЫ" + ConsoleColors.RESET) ;

        synchronized (locker) {
            threadsCount -= 1;
            if(threadsCount == 0) finish();
        }
    }

    private void makeFriedEggs() throws InterruptedException {
        boolean eggsFried = false;
        Burner freeBurner = null;
        System.out.println( ConsoleColors.YELLOW + "Начинаю готовить яичницу" + ConsoleColors.RESET) ;
        System.out.println( ConsoleColors.YELLOW + "Разбиваю яйца" + ConsoleColors.RESET) ;
        System.out.println( ConsoleColors.YELLOW + "Мешаю яйца с молоком" + ConsoleColors.RESET) ;
        System.out.println( ConsoleColors.YELLOW + "Солю это все" + ConsoleColors.RESET) ;

        while(!eggsFried) {
            synchronized (locker) {
                if (!burner1.isBusy()) {
                    burner1.setBusy();
                    freeBurner = burner1;
                }
            }

            if(freeBurner != null){
                freeBurner.HeatForTime(1000, "яичница", ConsoleColors.YELLOW );
                eggsFried  = true;
            }

            if(! eggsFried ) {
                synchronized (locker) {
                    if (!burner2.isBusy()) {
                        burner2.setBusy();
                        freeBurner = burner2;
                    }
                }
                if(freeBurner != null){
                    freeBurner.HeatForTime(1000, "яичница", ConsoleColors.YELLOW );
                    eggsFried  = true;
                }
                else {
                    Thread.sleep(10);
                }
            }
        }

        synchronized (locker) {
            freeBurner.setFree( ConsoleColors.YELLOW);
        }

        System.out.println( ConsoleColors.YELLOW + "Бросаю яичницу на тарелку" + ConsoleColors.RESET) ;
        System.out.println( ConsoleColors.YELLOW  + "[яичница]" + ConsoleColors.RESET + ConsoleColors.GREEN + " ГОТОВА" + ConsoleColors.RESET) ;

        synchronized (locker) {
            threadsCount -= 1;
            if(threadsCount == 0) finish();
        }
    }

    private void finish() {
        System.out.println( ConsoleColors.GREEN_BRIGHT + "Завтрак готов" + ConsoleColors.RESET) ;
    }
}
