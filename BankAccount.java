public class BankAccount {
    int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println("Amount withdrawn successfully by alice the new balance is:" + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        Thread alice = new Thread(new Runnable() {
            public void run() {
                account.withdraw(700);
            }
        });
        Thread bob = new Thread(new Runnable() {
            public void run() {
                account.withdraw(300);
            }
        });
        alice.start();
        bob.start();
    }
}
