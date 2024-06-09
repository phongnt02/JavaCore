package Synchronized;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("thread", 15);

        Runnable task1 = new WithDrawTask(account);
        Thread t1 = new Thread(task1);

        Runnable task2 = new WithDrawTask(account);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}
