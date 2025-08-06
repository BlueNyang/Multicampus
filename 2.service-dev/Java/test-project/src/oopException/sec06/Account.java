package oopException.sec06;

public class Account {
    private long balance;

    public Account() {
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(int money) {
        balance += money;
    }

    public void widthdraw(int money) throws BalanceInsufficientException {
        if (money > balance) {
            throw new BalanceInsufficientException("잔액이 부족합니다. 현재 잔액: " + balance + ", 출금액: " + money);
        }
        balance -= money;
    }
}
