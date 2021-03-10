package main.java.hw.TaskOne;


public class EverySec implements Runnable {
    SyncTime timer;
    EverySec(SyncTime timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        try {
            timer.everySec();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
