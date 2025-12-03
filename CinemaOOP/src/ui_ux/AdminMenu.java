package ui_ux;

import helper.ClearScreen;

import java.util.Scanner;

public class AdminMenu {
    public static void manageMovie(){
        ClearScreen.clearScreen();
//        TODO: MAKE CRUD MOVIE
    }
    public static void manageTheatre(){
        ClearScreen.clearScreen();
//        TODO: MAKE CRUD THEATRE
    }
    public static void adminMenu(){
        ClearScreen.clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("   _      _       _      _    _            _           ");
        System.out.println("  /_\\  __| |_ __ (_)_ _ (_)__| |_ _ _ __ _| |_ ___ _ _ ");
        System.out.println(" / _ \\/ _` | '  \\| | ' \\| (_-<  _| '_/ _` |  _/ _ \\ '_|");
        System.out.println("/_/ \\_\\__,_|_|_|_|_|_||_|_/__/\\__|_| \\__,_|\\__\\___/_|  ");
        System.out.println();
        System.out.println("1. Manage Movie");
        System.out.println("2. Manage Theatre");
        System.out.println();
        String input;
        int choice = -1;
        while (true) {
            System.out.print("Choose an option (1-2) or type \"n\" to exit: ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("n")) {
                System.out.println("Exiting menu...");
                scanner.close();
                return;
            }

            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 2) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1 or 2 (or 'n' to exit).");
            }
        }

        switch (choice) {
            case 1:
                System.out.println("\nYou selected: Manage Movie");
                manageMovie();
                break;
            case 2:
                System.out.println("\nYou selected: Manage Theatre");
                manageTheatre();
                break;
            default:
                System.out.println("Unexpected option.");
        }

        scanner.close();
    }
}
