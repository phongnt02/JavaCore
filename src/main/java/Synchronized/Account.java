package Synchronized;

public class Account {
    private String userName;
    private double amount;

    public Account(String userName, double amount) {
        this.userName = userName;
        this.amount = amount;
    }

    public synchronized void withDraw(double money) throws InterruptedException {
        if (this.amount >= money && this.amount > 0) {
            Thread.sleep(5000);
            this.amount = this.amount - money;
            System.out.println("SD:" + this.amount);
        } else {
            System.out.println("Not enought money");
        }
    }
}
