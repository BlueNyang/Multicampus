package com.mc.b_coffeemanager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayCoffeeManager {
    public static void main(String[] args) {

        String[] names = { "americano", "mocha", "latte", "frupuchino" };
        int[] prices = { 1000, 2000, 3000, 4000 };
        int[] costs = { 500, 1000, 1500, 2000 };
        int[] stocks = { 10, 10, 10, 10 };
        int[] safetyStocks = { 3, 3, 3, 3 };
        int[] salesCnts = { 0, 0, 0, 0};

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
                    for (int i = 0; i < names.length; i++) {
                        System.out.println(names[i] + "(" + i + ")");
                    }

                    System.out.print("번호 : ");
                    int drinkNo = sc.nextInt();
                    System.out.print("수량 : ");
                    int orderCnt = sc.nextInt();

                    if (drinkNo < 0 || drinkNo >= names.length) {
                        System.out.println("잘못 입력하셨습니다.");
                        continue;
                    }

                    // 주문수량 <= 재고
                    if (orderCnt <= stocks[drinkNo]) {
                        // 재고차감
                        stocks[drinkNo] -= orderCnt;
                        // 매출등록
                        salesAmount += orderCnt * prices[drinkNo];
                        // 잔고등록
                        balance += orderCnt * prices[drinkNo];
                    } else {
                        int purchasePrice = orderCnt * costs[drinkNo];
                        if (purchasePrice >= balance) {
                            System.out.println("system : 주문을 취소합니다.");
                            continue;
                        }

                        System.out.println("system : " + names[drinkNo] + " " + orderCnt + "개 매입합니다.");
                        // 재고 추가
                        stocks[drinkNo] += orderCnt;
                        // 지출 등록
                        expensesAmount += purchasePrice;
                        // 잔고 등록
                        balance -= purchasePrice;

                        // 재고차감
                        stocks[drinkNo] -= orderCnt;
                        // 매출등록
                        salesAmount += orderCnt * prices[drinkNo];
                        // 잔고등록
                        balance += orderCnt * prices[drinkNo];
                    }

                    // 안전재고 수량확인
                    if (stocks[drinkNo] <= safetyStocks[drinkNo]) {
                        // 안전재고 확보
                        int purchasePrice = safetyStocks[drinkNo] * 2 * costs[drinkNo];

                        if (balance >= purchasePrice) {
                            stocks[drinkNo] += safetyStocks[drinkNo] * 2;
                            balance -= purchasePrice;
                            expensesAmount += purchasePrice;
                            System.out.println("system : 안전재고 확보");
                        } else {
                            System.out.println("system : 잔액부족으로 안전재고 확보 실패");
                        }
                    }

                    System.out.println("\n 제품명 : " + names[drinkNo] + "\n 판매가 : " + prices[drinkNo] + "\n 판매수량 : "
                            + orderCnt + "\n 결재금액 : " + orderCnt * prices[drinkNo] + "\n 남은 재고 : " + stocks[drinkNo]);

                } else {
                    System.out.println("\n==== info ====\n");

                    for (int i = 0; i < names.length; i++) {
                        System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n"
                                , names[i], stocks[i], salesCnts[i]);
                    }

                    System.out.printf("잔고 : %4d | 매출 : %8d | 지출 %8d \n", balance, salesAmount, expensesAmount);
                }

            } catch (NoSuchElementException e) {
                System.out.println("system : 잘못 입력하셨습니다.");
            }
        }
    }
}
