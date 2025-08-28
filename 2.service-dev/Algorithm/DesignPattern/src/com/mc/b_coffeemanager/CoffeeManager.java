package com.mc.b_coffeemanager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CoffeeManager {

    public static void main(String[] args) {

        String americanoName = "americano";
        int americanoPrice = 1000;
        int americanoCost = 500;
        int americanoStock = 10;
        int americanoSafetyStock = 3;
        int americanoSalesCnt = 0;

        String mochaName = "mocha";
        int mochaPrice = 2000;
        int mochaCost = 1000;
        int mochaStock = 10;
        int mochaSafetyStock = 3;
        int mochaSalesCnt = 0;

        String latteName = "latte";
        int lattePrice = 3000;
        int latteCost = 1500;
        int latteStock = 10;
        int latteSafetyStock = 3;
        int latteSalesCnt = 0;

        int balance = 100000;
        int salesAmount = 0;
        int expensesAmount = 0;

        while(true) {
            Scanner sc = new Scanner(System.in);

            try {
                System.out.println("\n==== menu ====\n");
                System.out.println("판매등록(1)");
                System.out.println("현황(2)");
                System.out.println("종료(3)");

                System.out.print("입력 : ");
                int menu = sc.nextInt();

                if(menu == 3) {
                    System.out.println("system : 종료합니다.");
                    break;
                }

                if(menu < 1 || menu > 3) {
                    System.out.println("system : 잘못 입력하셨습니다.");
                    continue;
                }

                if(menu == 1) {
                    System.out.println("\n==== list ====\n");
                    System.out.println("americano(0)");
                    System.out.println("mocha(1)");
                    System.out.println("latte(2)");

                    System.out.print("번호 : ");
                    int drinkNo = sc.nextInt();
                    System.out.print("수량 : ");
                    int orderCnt = sc.nextInt();

                    if(drinkNo < 0 || drinkNo > 2) {
                        System.out.println("잘못 입력하셨습니다.");
                        continue;
                    }

                    if(drinkNo == 0) {
                        if(orderCnt <= getAmericanoStock(americanoStock)) {
                            americanoStock -= orderCnt;
                            salesAmount += orderCnt * americanoPrice;
                            balance += orderCnt * americanoPrice;
                        }else {
                            int purchasePrice = orderCnt * americanoCost;
                            if(purchasePrice >= balance) {
                                System.out.println("system : 주문을 취소합니다.");
                                continue;
                            }

                            System.out.println("system : " + americanoName + " " + orderCnt + "개 매입합니다.");
                            americanoStock += orderCnt;
                            expensesAmount += purchasePrice;
                            balance -= purchasePrice;

                            americanoStock -= orderCnt;
                            salesAmount += orderCnt * americanoPrice;
                            balance += orderCnt * americanoPrice;
                        }

                        if(americanoStock <= americanoSafetyStock) {
                            int purchasePrice = americanoSafetyStock * 2 * americanoCost;

                            if(balance >= purchasePrice) {
                                americanoStock += americanoSafetyStock * 2;
                                balance -= purchasePrice;
                                expensesAmount += purchasePrice;
                                System.out.println("system : 안전재고 확보");
                            }else {
                                System.out.println("system : 잔액부족으로 안전재고 확보 실패");
                            }
                        }

                        System.out.println("\n 제품명 : " + americanoName +
                                "\n 판매가 : " + americanoPrice +
                                "\n 판매수량 : " + orderCnt +
                                "\n 결재금액 : " + orderCnt * americanoPrice +
                                "\n 남은 재고 : " + americanoStock
                        );

                    }else if(drinkNo == 1) {
                        if(orderCnt <= mochaStock) {
                            mochaStock -= orderCnt;
                            salesAmount += orderCnt * mochaPrice;
                            balance += orderCnt * mochaPrice;
                        }else {
                            int purchasePrice = orderCnt * mochaCost;
                            if(purchasePrice >= balance) {
                                System.out.println("system : 주문을 취소합니다.");
                                continue;
                            }

                            System.out.println("system : " + mochaName + " " + orderCnt + "개 매입합니다.");
                            mochaStock += orderCnt;
                            expensesAmount += purchasePrice;
                            balance -= purchasePrice;

                            mochaStock -= orderCnt;
                            salesAmount += orderCnt * mochaPrice;
                            balance += orderCnt * mochaPrice;
                        }

                        if(mochaStock <= mochaSafetyStock) {
                            int purchasePrice = mochaSafetyStock * 2 * mochaCost;

                            if(balance >= purchasePrice) {
                                mochaStock += mochaSafetyStock * 2;
                                balance -= purchasePrice;
                                expensesAmount += purchasePrice;
                                System.out.println("system : 안전재고 확보");
                            }else {
                                System.out.println("system : 잔액부족으로 안전재고 확보 실패");
                            }
                        }

                        System.out.println("\n 제품명 : " + mochaName +
                                "\n 판매가 : " + mochaPrice +
                                "\n 판매수량 : " + orderCnt +
                                "\n 결재금액 : " + orderCnt * mochaPrice +
                                "\n 남은 재고 : " + mochaStock
                        );

                    }else {
                        if(orderCnt <= latteStock) {
                            latteStock -= orderCnt;
                            salesAmount += orderCnt * lattePrice;
                            balance += orderCnt * lattePrice;
                        }else {
                            int purchasePrice = orderCnt * latteCost;
                            if(purchasePrice >= balance) {
                                System.out.println("system : 주문을 취소합니다.");
                                continue;
                            }

                            System.out.println("system : " + latteName + " " + orderCnt + "개 매입합니다.");
                            latteStock += orderCnt;
                            expensesAmount += purchasePrice;
                            balance -= purchasePrice;

                            latteStock -= orderCnt;
                            salesAmount += orderCnt * lattePrice;
                            balance += orderCnt * lattePrice;
                        }

                        if(latteStock <= latteSafetyStock) {
                            int purchasePrice = latteSafetyStock * 2 * latteCost;

                            if(balance >= purchasePrice) {
                                latteStock += latteSafetyStock * 2;
                                balance -= purchasePrice;
                                expensesAmount += purchasePrice;
                                System.out.println("system : 안전재고 확보");
                            }else {
                                System.out.println("system : 잔액부족으로 안전재고 확보 실패");
                            }
                        }

                        System.out.println("\n 제품명 : " + latteName +
                                "\n 판매가 : " + lattePrice +
                                "\n 판매수량 : " + orderCnt +
                                "\n 결재금액 : " + orderCnt * lattePrice +
                                "\n 남은 재고 : " + latteStock
                        );

                    }
                }else {
                    System.out.println("\n==== info ====\n");
                    System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", americanoName, americanoStock, americanoSalesCnt);
                    System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", mochaName, mochaStock, mochaSalesCnt);
                    System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", latteName, latteStock, latteSalesCnt);
                    System.out.printf("잔고 : %4d | 매출 : %8d | 지출 %8d \n", balance, salesAmount, expensesAmount );
                }
            }catch (NoSuchElementException e) {
                System.out.println("system : 잘못 입력하셨습니다.");
            }
        }
    }

    private static int getAmericanoStock(int americanoStock) {
        return americanoStock;
    }
}
