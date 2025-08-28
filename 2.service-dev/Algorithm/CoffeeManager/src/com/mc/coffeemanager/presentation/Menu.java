package com.mc.coffeemanager.presentation;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.multilang.payment.translate.ChinaDecorator;
import com.mc.coffeemanager.domain.multilang.payment.translate.SpainDecorator;
import com.mc.coffeemanager.domain.multilang.payment.translate.Translatable;
import com.mc.coffeemanager.domain.multilang.payment.translate.UsaDecorator;
import com.mc.coffeemanager.domain.order.Order;
import com.mc.coffeemanager.domain.payment.Payment;
import com.mc.coffeemanager.domain.sale.SaleContext;

import java.util.NoSuchElementException;
import java.util.Scanner;

// presentation : 표현계층
// 서비스 외부의 요청을 받고 응답을 보내는 계층
public class Menu {
    private final SaleContext saleContext = new SaleContext();
    private final Coffee[] coffees;
    private final Account account = Account.getInstance();
    Scanner sc = new Scanner(System.in);

    public Menu(Coffee[] coffees) {
        super();
        this.coffees = coffees;
    }

    public void menu() {
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

        Translatable<Payment> payment = saleContext.init(order);

            System.out.println("\nSelect language:");
            System.out.println("  1. English");
            System.out.println("  2. Spanish");
            System.out.println("  3. Chinese");
            System.out.println("  4. None(Korean)");
            System.out.print("Enter the number: ");
            int langChoice = sc.nextInt();
            if (langChoice != 4) {
                payment = switch (langChoice) {
                    case 1 -> new UsaDecorator(payment);
                    case 2 -> new ChinaDecorator(payment);
                    case 3 -> new SpainDecorator(payment);
                    default -> throw new IllegalArgumentException("Invalid input.");
                };
            }

        System.out.println("\n Coffee Name : " + coffees[drinkNo].getName()
                + "\n Price : " + coffees[drinkNo].getPrice()
                + "\n Sales Count : " + orderCnt
                + "\n Total Sales : " + orderCnt * coffees[drinkNo].getPrice()
                + "\n Stock Count : " + coffees[drinkNo].getStock());
        System.out.println("\n==== Payment ====\n");
        System.out.println(payment.translate());
    }
}
