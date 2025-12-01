package ui_ux;

import java.util.Scanner;
import helper.ClearScreen;

public class MainMenu {
    ClearScreen clearScreen = new ClearScreen();
    public void showTicketTransaction(){

    }
    public void seat(){
        showTicketTransaction();
    }
    public void schedule(){
        seat();
    }
    public void theatre(){
        clearScreen.clearScreen();
        System.out.println("  _____ _             _              ");
        System.out.println(" |_   _| |_  ___ __ _| |_ _ _ ___ ___");
        System.out.println("   | | | ' \\/ -_) _` |  _| '_/ -_|_-<");
        System.out.println("   |_| |_||_\\___\\__,_|\\__|_| \\___/__/");
        System.out.println("                                     ");
//        DISPLAY MOVIE INFO
//        System.out.println("Title 2");
//        System.out.println("Director: Director 2 ");
//        System.out.println("Actors: Actor 1, Actor 2, Actor 3");
//        System.out.println("Genre: Sci-Fi");
//        System.out.println("Rating: PG-13");
//        System.out.println("Length: 169m");
        System.out.println();
        System.out.println("Pick a Theatre! ");
        System.out.println();
//        SHOW THEATRE LIST THAT SHOWS THE MOVIE
//        System.out.println("1. Theatre Alpha | Studio 3");
//        System.out.println("2. Theatre Beta  | Studio 1");
//        System.out.println("3. Theatre Sigma | Studio 5");
        System.out.println();
        System.out.println("(Type \"n\" to go back)");
        String theatre;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter theatre name [case insensitive]");
            System.out.print(">> ");
            theatre = scanner.nextLine();
//            CHECK IF MOVIE IS IN THE LIST
            if(theatre.equals("n")){
                return;
            }
            break; // TEMPORARY BREAK
        }
        schedule();

    }
    public void movie(){
        clearScreen.clearScreen();
        System.out.println("  __  __         _        ");
        System.out.println(" |  \\/  |_____ _(_)___ ___");
        System.out.println(" | |\\/| / _ \\ V / / -_|_-<");
        System.out.println(" |_|  |_\\___/\\_/|_\\___/__/");
        System.out.println("                          ");
        System.out.println("Pick a Movie!");
        System.out.println();
//      SHOW MOVIE LIST
//        System.out.println("1. Title 1 | Horror  | R      | 125m");
//        System.out.println("2. Title 2 | Sci-Fi  | PG-13  | 169m");
//        System.out.println("3. Title 3 | Romance | G      | 120m");
//        System.out.println("4. Title 4 | Drama   | NC-17  | 180m");
//        System.out.println("5. Title 5 | Action  | PG     | 90m");
//        System.out.println("6. Title 6 | Comedy  | G      | 102m");
        System.out.println();
        System.out.println("(Type \"n\" to go back)");
        String movie;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter title [case insensitive]");
            System.out.print(">> ");
            movie = scanner.nextLine();
//            CHECK IF MOVIE IS IN THE LIST
            if(movie.equals("n")){
                return;
            }
            break; // TEMPORARY BREAK
        }
        theatre();
    }
    public void mainMenu(){
        clearScreen.clearScreen();
        System.out.println("  __  _  _  _  ___  _   _   _     _   _  ___ ");
        System.out.println(" / _|| || \\| || __|| \\_/ | / \\   / \\ / \\| o \\");
        System.out.println("( (_ | || \\\\ || _| | \\_/ || o | ( o | o )  _/");
        System.out.println(" \\__||_||_|\\_||___||_| |_||_n_|  \\_/ \\_/|_|  ");
        System.out.println();
        System.out.println("1. Watch Movie");
        System.out.println("2. View Tickets");
        System.out.println("3. Log Out");
        System.out.println("4. Exit");
        int choice;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(">>");
            if(scanner.hasNextInt()){
                choice = scanner.nextInt();
                scanner.nextLine();
                if(choice >= 1 && choice <= 4){
                    break;
                } else {
                    System.out.println("Choice must be 1 - 4");
                }
            } else {
                scanner.nextLine();
                System.out.println("Choice must be a number");
            }
        }
        switch (choice){
            case 1:
                movie();
                break;
            case 2:
                break;
            case 3:
                return;
            case 4:
                System.out.println("Closing Cinema OOP...");
                System.exit(0);
                break;
        }
    }
}
