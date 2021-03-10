package main.java.hw.TaskOne;


public class Every5Sec implements Runnable {
    SyncTime timer;
    Every5Sec(SyncTime timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        try {
            timer.every5Sec();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

