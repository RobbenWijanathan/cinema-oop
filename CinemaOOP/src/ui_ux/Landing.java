package ui_ux;

import java.util.Scanner;
import helper.ClearScreen;

public class Landing {
    public static void login(){
        ClearScreen.clearScreen();
        String username, password;
        System.out.println("  _              _      ");
        System.out.println(" | |   ___  __ _(_)_ _  ");
        System.out.println(" | |__/ _ \\/ _` | | ' \\ ");
        System.out.println(" |____\\___/\\__, |_|_||_|");
        System.out.println("           |___/         ");
        System.out.println();
        System.out.println("(Type \"n\" to go back)");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter Username [more than 4 characters]");
            System.out.print(">> ");
            username = scanner.nextLine();
            if(username.length() > 4){
                break;
            } else {
                System.out.println("Username must be more than 5 characters");
            }
//            TODO: CHECK IF USERNAME IS NOT IN THE DATABASE
            if(username.equals("n")){
                return;
            }
        }

        while(true){
            System.out.println("Enter Password");
            System.out.print(">> ");
            password = scanner.nextLine();
//            TODO: CHECK IF PASSWORD != PASSWORD IN THE DATABASE
            if(password.equals("n")){
                return;
            }
            break; // temporary break
        }

        if(username.equals("admin")){
            AdminMenu.adminMenu();
        } else {
            MainMenu.mainMenu();
        }
    }
    public static void register(){
        ClearScreen.clearScreen();
        Scanner scanner = new Scanner(System.in);

        System.out.println("  ___          _    _           ");
        System.out.println(" | _ \\___ __ _(_)__| |_ ___ _ _ ");
        System.out.println(" |   / -_) _` | (_-<  _/ -_) '_|");
        System.out.println(" |_|_\\___\\__, |_/__/\\__\\___|_|  ");
        System.out.println("         |___/                  ");
        System.out.println();
        System.out.println("(Type \"n\" to go back)");

        System.out.println("Enter Username");
        System.out.print(">> ");
        String username = scanner.nextLine();

        if (username.equalsIgnoreCase("n")) {
            return;
        }

        String password;
        while (true) {
            System.out.println("\nEnter password [8-16 characters (at least 1 letter and 1 number)]");
            System.out.print(">> ");
            password = scanner.nextLine();

            if (password.equalsIgnoreCase("n")) {
                return;
            }

            boolean validLength = password.length() >= 8 && password.length() <= 16;
            boolean hasLetter = password.matches(".*[A-Za-z].*");
            boolean hasDigit = password.matches(".*[0-9].*");
            boolean isAlphanumeric = password.matches("[A-Za-z0-9]+");

            if (!validLength) {
                System.out.println("Password must be 8-16 characters long!");
                continue;
            }
            if (!isAlphanumeric) {
                System.out.println("Password must be alphanumeric (letters & numbers only)!");
                continue;
            }
            if (!hasLetter || !hasDigit) {
                System.out.println("Password must contain at least 1 letter and 1 number!");
                continue;
            }

            break;
        }

        while (true) {
            System.out.println("\nConfirm Password");
            System.out.print(">> ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("n")) {
                return;
            }
            if (!confirm.equals(password)) {
                System.out.println("Passwords do not match! Try again.");
                continue;
            }
            break;
        }

//        TODO: ADD NEW USER FROM THE REGIS DATA

        System.out.println("\nYou're Registered!");
        System.out.println(">> Enter to go back to main menu");
        scanner.nextLine();

    }
    public static void loginRegister() {
        ClearScreen.clearScreen();
        System.out.println(" __  _  _  _  ___  _   _   _     _   _  ___ ");
        System.out.println(" / _|| || \\| || __|| \\_/ | / \\   / \\ / \\| o \\");
        System.out.println("( (_ | || \\\\ || _| | \\_/ || o | ( o | o )  _/");
        System.out.println(" \\__||_||_|\\_||___||_| |_||_n_|  \\_/ \\_/|_|  ");
        System.out.println();
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        int landingChoice;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print(">> ");
            if(scanner.hasNextInt()){
                landingChoice = scanner.nextInt();
                scanner.nextLine();
                if(landingChoice >= 1 && landingChoice <= 3){
                    break;
                } else {
                    System.out.println("Choice must be 1 - 3.");
                }
            }  else {
                scanner.nextLine();
                System.out.println("Choice must be a number.");
            }
        }
        switch (landingChoice){
            case 1:
                login();
                loginRegister();
                break;
            case 2:
                register();
                loginRegister();
                break;
            case 3:
                System.out.println("Closing Cinema OOP...");
                System.exit(0);
                break;
        }
    }
}
