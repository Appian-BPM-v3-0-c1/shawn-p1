package com.revature.shop.ui;

import com.revature.shop.daos.ProductDAO;
import com.revature.shop.daos.PurchaseHistoryDAO;
import com.revature.shop.models.User;
import com.revature.shop.services.ProductService;
import com.revature.shop.services.PurchaseHistoryService;
import com.revature.shop.services.ShoppingCartService;
import com.revature.shop.daos.ShoppingCartDAO;
import java.util.Scanner;

public class MainMenu implements IMenu {
    private final User user;

    public MainMenu(User user) {
        this.user = user;
    }

    @Override
    public void start() {
        char input = ' ';

        boolean exit = false;

        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nWelcome to Color Magic " + user.getUsername() + "!");
            System.out.println("[1] Purchase Color Pencils");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    new ProductMenu(new PurchaseHistoryService(new PurchaseHistoryDAO()), new ProductService(new ProductDAO()),new ShoppingCartService(new ShoppingCartDAO()), user).start();
                    break;
                case 'x':
                    exit = true;
                    break;

                default:
                    System.out.println("\nInvalid Input, Try Again!");
                    break;
            }
        }
    }
}