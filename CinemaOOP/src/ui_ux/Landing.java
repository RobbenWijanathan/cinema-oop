package ui_ux;

import java.util.Scanner;
import helper.ClearScreen;

public class Landing {
    MainMenu mainMenu = new MainMenu();
    AdminMenu adminMenu = new AdminMenu();
    ClearScreen clearScreen = new ClearScreen();
    public void login(){
        clearScreen.clearScreen();
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
//            CHECK IF USERNAME IS NOT IN THE DATABASE
            if(username.equals("n")){
                return;
            }
        }

        while(true){
            System.out.println("Enter Password");
            System.out.print(">> ");
            password = scanner.nextLine();
//            CHECK IF PASSWORD != PASSWORD IN THE DATABASE
            break; // temporary break
//            if(password.equals("n")){
//                return;
//            }
        }

        if(username.equals("admin")){
            adminMenu.adminMenu();
        } else {
            mainMenu.mainMenu();
        }
    }
    public void register(){
        clearScreen.clearScreen();
    }
    public void loginRegister() {
        clearScreen.clearScreen();
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
