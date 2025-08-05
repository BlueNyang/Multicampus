package oopException.sec06;

public class BalanceInsufficientException extends Exception {
    public BalanceInsufficientException() {
    }

    public BalanceInsufficientException(String message) {
        super(message);
    }
}
