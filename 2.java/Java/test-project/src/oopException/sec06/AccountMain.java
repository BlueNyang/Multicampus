package oopException.sec06;

import java.util.ArrayList;

public class AccountMain {
    public static void main(String[] ignoredArgs) {
        Account account = new Account();

        account.deposit(10000);
        System.out.println("현재 잔액: " + account.getBalance());

        try {
            account.widthdraw(3000);
            System.out.println("출금 성공, 현재 잔액: " + account.getBalance());

            account.widthdraw(8000);
            System.out.println("출금 성공, 현재 잔액: " + account.getBalance());
        } catch (BalanceInsufficientException e) {
            String message = e.getMessage();
            System.out.println("출금 실패: " + message);
            System.out.println();
            System.out.println("Exception Stack Trace:");
            e.printStackTrace();
        }
    }
}
