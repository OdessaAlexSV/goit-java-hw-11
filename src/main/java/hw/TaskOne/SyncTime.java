package main.java.hw.TaskOne;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SyncTime {
    private int timer;
    private int counterSec = 1;

    public SyncTime(int timer) {
        this.timer = timer;
    }

    public synchronized void everySec() throws InterruptedException {
        while (timer > 0) {
            Thread.sleep(1000);
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss");
            System.out.println(formatForDateNow.format(new Date()));
            counterSec++;
            timer--;
            notifyAll();
            while (counterSec % 5 == 0) {
                if (timer <= 0) {
                    break;
                }
                wait();
            }
        }
        counterSec--;
        System.out.println("Time is over. Passed " + counterSec + " sec.");
    }

    public synchronized void every5Sec() throws InterruptedException {
        while (timer > 0) {
            while (counterSec % 5 != 0) {
                if (timer <= 0) {
                    break;
                }
                wait();
            }
            if (timer > 0) {
                Thread.sleep(1000);
                System.out.println("5 sec passed");
                counterSec++;
                timer--;
                notifyAll();
            }
        }
    }
}
