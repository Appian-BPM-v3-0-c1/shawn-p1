package com.revature.shop.ui;

import com.revature.shop.models.User;
import com.revature.shop.services.UserService;


import java.util.Locale;
import java.util.Scanner;



public class LoginMenu implements IMenu{
    private UserService userService;

    public LoginMenu(UserService userService) {
        this.userService = userService;
    }

    Scanner scan = new Scanner(System.in);
    User user = new User();

    @Override
    public void start() {
        char input;

        exit: {
            while (true) {
                System.out.println("Welcome back! Please log in");
                System.out.println("[1] Login");
                System.out.println("[2] First time? Create a new account!");
                System.out.println("[x] Exit");

                input = scan.next().charAt(0);

                switch (input) {
                    case '1':
                        login();
                        break;
                    case '2':
                        createAccount();
                        break;
                    case 'x':
                        break exit;
                    default:
                        System.out.println("Invalid Input! Try Again!");
                        break;


                }
            }
        }
    }
    private void createAccount() {



        String username = "";
        String password1 = "";
        String password2 = "";
        String firstName = "";
        String lastName = "";
        String address = "";
        String email = "";
        String city = "";
        String state = "";

        scan.nextLine();

        System.out.println("\nCreating your account...~");

        System.out.println("\nEnter your first name: ");
        user.setFirstName(scan.nextLine().toLowerCase());

        System.out.println("\nEnter your last name: ");
        user.setLastName(scan.nextLine().toLowerCase());

        System.out.println("\nEnter your mailing address: ");
        user.setAddress(scan.nextLine().toLowerCase());

        System.out.println("\nEnter your email address: ");
        user.setEmail(scan.nextLine().toLowerCase());

        System.out.println("\nEnter your city: ");
        user.setCity(scan.nextLine().toLowerCase());

        System.out.println("\nEnter your state: ");
        user.setState(scan.nextLine().toLowerCase());

        while (true) {
            while (true) {
                System.out.println("\nPlease enter a username: ");
                username = scan.nextLine();

                if (!userService.isDupUsername(username)) {
                    if (userService.isValidUsername(username)) {
                        user.setUsername(username);
                        break;
                    } else {
                        System.out.println("\nSorry, invalid username T^T");
                    }

                } else {
                    System.out.println("\nOops! That name is taken already! T^T");
                }
            }

            while (true) {
                System.out.println("\nEnter your password:");
                password1 = scan.nextLine();

                System.out.println("\nPlease enter your password again:");
                password2 = scan.nextLine();

                if (password1.equals(password2)) {
                    if (userService.isValidPassword(password1)) {
                        user.setPassword(password1);
                        break;
                    } else {
                        System.out.println("Invalid Password!");
                    }
                } else {
                    System.out.println("Whoops! Your password doesn't match!");
                }
            }

            System.out.println("\nIs this correct? (y/n)");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password1);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Address: " + address);
            System.out.println("Email: " + email);
            System.out.println("City: " + city);
            System.out.println("State: " + state);

            System.out.print("\nEnter: ");

            if (scan.next().charAt(0) == 'y') {
                userService.getUserDAO().save(user);

                System.out.println("Your account has been successfully created!");
                break;
            }
        }

    }
    private void login() {
        while (true) {
            System.out.print("\nUsername: ");
            user.setUsername(scan.next());

            System.out.print("\nPassword: " );
            user.setPassword((scan.next()));

            if (userService.isValidLogin(user)) {
                user = userService.getUserDAO().findByUsername(user.getUsername());
                new MainMenu(user).start();
                break;
            } else {
                System.out.println("\nInvalid Login!");
                }
            }
        }
    }

