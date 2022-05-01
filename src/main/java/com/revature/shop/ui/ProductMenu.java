package com.revature.shop.ui;

import com.revature.shop.models.Product;
import com.revature.shop.models.User;
import com.revature.shop.models.ShoppingCart;
import com.revature.shop.models.PurchaseHistory;
import com.revature.shop.services.ProductService;
import com.revature.shop.services.ShoppingCartService;
import com.revature.shop.services.PurchaseHistoryService;

import java.util.List;
import java.util.Scanner;

public class ProductMenu implements IMenu {
    public ProductMenu(PurchaseHistoryService purchaseHistoryService, ProductService productService, ShoppingCartService shoppingCartService, User user) {
        this.purchaseHistoryService = purchaseHistoryService;
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
        this.user = user;
    }
    private final PurchaseHistoryService purchaseHistoryService;
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;
    private final User user;

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {

            System.out.println("What're ya buyin'?");
            System.out.println("[1] View all Color Pencils");
            System.out.println("[2] View Shopping Cart");
            System.out.println("[3] View Purchase History");
            System.out.println("[4] Checkout");
            System.out.println("[x] Exit");


            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    viewAllColorPencils();
                    break;
                case '2': viewCart();
                    break;
                case '3':viewHistory();
                    break;
                case '4':checkout();
                    break;
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid Input!");
                    break;
            }
        }
    }

    private void checkout() {
    }

    private void viewAllColorPencils() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        List<Product> productList = productService.getProductDAO().findAll();

        System.out.println();
        for (int i = 0; i < productList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + productList.get(i).getItemName());
        }
        while (true) {
            System.out.println("\nWhich item do you want?");
            input = scan.nextInt() - 1;

            if (input > productList.size()) {
                System.out.println("\nInvalid Input!");
            } else {
                System.out.println(productList.get(input));
                System.out.println("\nIs this the item you want? (y/n)");
                if (scan.next().charAt(0) == 'y') {
                    Product product = productList.get(input);
                    buyItem(product);
                    break;
                } else {
                    System.out.println("\nMaybe next time...:(");
                    break;
                }
            }
        }
    }

    private void buyItem(Product product) {
        int input = 0;
        boolean exit = false;


        Scanner scan = new Scanner(System.in);
        exit:
        {
            System.out.println(product);
            System.out.println("\nWould you like to add to cart? (y/n)");
            input = scan.next().charAt(0);
            switch (input) {
                case 'y':
                    if (product.getQuantity() > 0) {
                        ShoppingCart cart = new ShoppingCart();
                        cart.setItemId(product.getItemId());
                        cart.setPrice(product.getPrice());
                        cart.setItemName(product.getItemName());
                        cart.setQuantity(product.getQuantity());
                        shoppingCartService.getShoppingCartDAO().save(cart);
                        System.out.print("Item added successfully!");
                        break exit;
                    } else {
                        System.out.println("Out of stock");
                        break exit;
                    }
                case 'n':
                    System.out.println("Nevermind then :(");
                    break exit;
            }
        }
    }


    private void viewCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        List<ShoppingCart> carts = shoppingCartService.getShoppingCartDAO().findCartById(shoppingCart.getItemId());

        Scanner scan = new Scanner(System.in);

            while(true) {
              for (ShoppingCart c: carts) {
                  System.out.println(productService.getProductDAO().findById(c.getItemId()));
                  System.out.println("Would you like to go checkout?");
                    if (scan.nextLine().charAt(0) == 'y'); {
                        checkout((List<ShoppingCart>) shoppingCart);
                  }
              }
            }

    }

    private void viewHistory() {
        User user = new User();
        List<PurchaseHistory> history = purchaseHistoryService.getPurchaseHistoryDAO().findHistoryById(user.getUserId());
        for( PurchaseHistory h: history) {
            System.out.println(productService.getProductDAO());
        }
    }

    private void checkout(List<ShoppingCart> carts) {
        ShoppingCart shoppingCart = new ShoppingCart();
        for (ShoppingCart c : carts) {
           shoppingCart.setItemId(c.getItemId());
            shoppingCart.setItemName(c.getItemName());
            shoppingCart.setQuantity(c.getQuantity());
            shoppingCart.setPrice(c.getPrice());
            productService.getProductDAO().removeItemById(c.getItemId());
        }
    }
}
