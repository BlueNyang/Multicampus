package com.mc.b_coffeemanager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClassCoffeeManager {

    public static void main(String[] args) {
        Coffee[] coffees = { new Coffee("americano", 1000, 500, 10, 3, 0), new Coffee("mocha", 2000, 1000, 10, 3, 0),
                new Coffee("latte", 3000, 1500, 10, 3, 0), new Coffee("frupuchino", 4000, 2000, 10, 3, 0) };

        int balance = 100000;
        int salesAmount = 0;
        int expensesAmount = 0;

        while (true) {
            Scanner sc = new Scanner(System.in);

            try {
                System.out.println("\n==== menu ====\n");
                System.out.println("판매등록(1)");
                System.out.println("현황(2)");
                System.out.println("종료(3)");

                System.out.print("입력 : ");
                int menu = sc.nextInt();

                if (menu == 3) {
                    System.out.println("system : 종료합니다.");
                    break;
                }

                if (menu < 1 || menu > 3) {
                    System.out.println("system : 잘못 입력하셨습니다.");
                    continue;
                }

                if (menu == 1) {
                    System.out.println("\n==== list ====\n");
                    for (int i = 0; i < coffees.length; i++) {
                        System.out.println(coffees[i].getName() + "(" + i + ")");
                    }

                    System.out.print("번호 : ");
                    int drinkNo = sc.nextInt();
                    System.out.print("수량 : ");
                    int orderCnt = sc.nextInt();

                    if (drinkNo < 0 || drinkNo >= coffees.length) {
                        System.out.println("잘못 입력하셨습니다.");
                        continue;
                    }

                    // 주문수량 <= 재고
                    if (orderCnt <= coffees[drinkNo].getStock()) {
                        // 재고차감
                        coffees[drinkNo].deductStock(orderCnt);
                        // 매출등록
                        salesAmount += orderCnt * coffees[drinkNo].getPrice();
                        // 잔고등록
                        balance += orderCnt * coffees[drinkNo].getPrice();
                    } else {
                        int purchasePrice = orderCnt * coffees[drinkNo].getCost();
                        if (purchasePrice >= balance) {
                            System.out.println("system : 주문을 취소합니다.");
                            continue;
                        }

                        System.out.println("system : " + coffees[drinkNo].getName() + " " + orderCnt + "개 매입합니다.");
                        // 재고 추가
                        coffees[drinkNo].addStock(orderCnt);
                        // 지출 등록
                        expensesAmount += purchasePrice;
                        // 잔고 등록
                        balance -= purchasePrice;

                        // 재고차감
                        coffees[drinkNo].deductStock(orderCnt);
                        // 매출등록
                        salesAmount += orderCnt * coffees[drinkNo].getPrice();
                        // 잔고등록
                        balance += orderCnt * coffees[drinkNo].getPrice();
                    }

                    // 안전재고 수량확인
                    if (coffees[drinkNo].getStock() <= coffees[drinkNo].getSafetyStock()) {
                        // 안전재고 확보
                        int purchasePrice = coffees[drinkNo].getSafetyStock() * 2 * coffees[drinkNo].getCost();

                        if (balance >= purchasePrice) {
                            coffees[drinkNo].addStock(coffees[drinkNo].getSafetyStock() * 2);
                            balance -= purchasePrice;
                            expensesAmount += purchasePrice;
                            System.out.println("system : 안전재고 확보");
                        } else {
                            System.out.println("system : 잔액부족으로 안전재고 확보 실패");
                        }
                    }

                    System.out.println("\n 제품명 : " + coffees[drinkNo].getName()
                            + "\n 판매가 : " + coffees[drinkNo].getPrice()
                            + "\n 판매수량 : " + orderCnt
                            + "\n 결재금액 : " + orderCnt * coffees[drinkNo].getPrice()
                            + "\n 남은 재고 : "+ coffees[drinkNo].getStock());

                } else {
                    System.out.println("\n==== info ====\n");

                    for (int i = 0; i < coffees.length; i++) {
                        System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n",
                                coffees[i].getName(), coffees[i].getStock(), coffees[i].getSalesAmount());
                    }

                    System.out.printf("잔고 : %4d | 매출 : %8d | 지출 %8d \n", balance, salesAmount, expensesAmount);
                }

            } catch (NoSuchElementException e) {
                System.out.println("system : 잘못 입력하셨습니다.");
            }
        }

    }

}
