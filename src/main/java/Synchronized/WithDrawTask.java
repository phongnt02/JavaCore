package Synchronized;

public class WithDrawTask implements Runnable{
    private Account account;

    public WithDrawTask(Account account) {
        this.account = account;
    }

    @Override
    public void run () {
        try {
            this.account.withDraw(10);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
