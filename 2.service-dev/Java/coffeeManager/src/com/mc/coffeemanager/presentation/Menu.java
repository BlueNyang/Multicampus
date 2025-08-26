package com.mc.coffeemanager.presentation;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.order.Order;
import com.mc.coffeemanager.domain.sale.SaleContext;

// presentation : 표현계층
// 서비스 외부의 요청을 받고 응답을 보내는 계층
public class Menu {
    private final SaleContext saleContext = new SaleContext();
    private final Coffee[] coffees;
    private final Account account = Account.getInstance();

    public Menu(Coffee[] coffees) {
        super();
        this.coffees = coffees;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\n==== menu ====\n");
                System.out.println("  Register Order (1)");
                System.out.println("  Current Status (2)");
                System.out.println("  Exit (3)");

                System.out.print("Enter the number : ");
                int menu = sc.nextInt();

                if (menu == 3) {
                    System.out.println("system : Exiting the system.");
                    break;
                }

                if (menu < 1 || menu > 3) {
                    System.out.println("system : Invalid input.");
                    continue;
                }

                if (menu == 1) {
                    System.out.println("\n==== list ====\n");
                    for (int i = 0; i < coffees.length; i++) {
                        System.out.println(coffees[i].getName() + "(" + i + ")");
                    }

                    System.out.print("number : ");
                    int drinkNo = sc.nextInt();
                    System.out.print("quantity : ");
                    int orderCnt = sc.nextInt();

                    if (drinkNo < 0 || drinkNo >= coffees.length) {
                        System.out.println("system : Invalid drink number.");
                        continue;
                    }

                    registOrder(drinkNo, orderCnt);
                } else {
                    for (Coffee coffee : coffees) {
                        System.out.printf("%-10s stock:%3d sale: %3d \n",
                                coffee.getName(), coffee.getStock(), coffee.getSalesCnt());
                    }

                    System.out.printf("balance : %4d | sales : %8d | purchases %8d \n"
                            , account.getBalance(), account.getSales(), account.getPurchase());
                }

            } catch (NoSuchElementException e) {
                System.out.println("Invalid input.");
            } catch (Exception e) {
                System.out.println("system : An error occurred.");
            }
        }
        sc.close();
    }

    private void registOrder(int drinkNo, int orderCnt) {
        Order order = Order.createOrder(coffees[drinkNo], orderCnt);

        if (order.getStatus().isFail()) {
            System.out.println("system : " + order.getStatus().desc());
            return;
        }

        saleContext.init(order);

        System.out.println("\n Coffee Name : " + coffees[drinkNo].getName()
                + "\n Price : " + coffees[drinkNo].getPrice()
                + "\n Sales Count : " + orderCnt
                + "\n Total Sales : " + orderCnt * coffees[drinkNo].getPrice()
                + "\n Stock Count : " + coffees[drinkNo].getStock());
    }
}
