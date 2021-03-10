package main.java.hw.TaskTwo;

import java.util.StringJoiner;

public class FizzBuzz {
    private int n;
    private int currentNumber = 1;
    StringJoiner finalStr = new StringJoiner(", ");

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (currentNumber <= n) {
            if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                finalStr.add("fizz");
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
        System.out.println(finalStr);
    }

    public synchronized void buzz() throws InterruptedException {
        while (currentNumber <= n) {
            if (currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                finalStr.add("buzz");
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (currentNumber <= n) {
            if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                finalStr.add("fizzbuzz");
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (currentNumber <= n) {
            if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                finalStr.add(String.valueOf(currentNumber));
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}