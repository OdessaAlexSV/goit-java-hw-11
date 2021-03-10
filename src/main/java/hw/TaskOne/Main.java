package main.java.hw.TaskOne;

public class Main {
    public static void main(String[] args) {
        SyncTime timer = new SyncTime(15);
        EverySec everySec = new EverySec(timer);
        Every5Sec every5Sec = new Every5Sec(timer);
        new Thread(everySec).start();
        new Thread(every5Sec).start();
    }
}
