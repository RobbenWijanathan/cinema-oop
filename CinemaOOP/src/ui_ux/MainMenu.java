package ui_ux;

import java.util.Scanner;
import helper.ClearScreen;

public class MainMenu {
    public static void showTicketTransaction(){
        ClearScreen.clearScreen();
        System.out.println("  ___                         _   ");
        System.out.println(" | _ \\__ _ _  _ _ __  ___ _ _| |_ ");
        System.out.println(" |  _/ _` | || | '  \\/ -_) ' \\  _|");
        System.out.println(" |_| \\__,_|\\_, |_|_|_\\___|_||_\\__|");
        System.out.println("           |__/                   ");
        System.out.println();
//        TODO: SHOW MOVIE, THEATRE AND STUDIO, SCHEDULE, AND SEATS
//        System.out.println("Title 2");
//        System.out.println("Theatre Alpha | Studio 3");
//        System.out.println("14:25 ");
//        System.out.println("F9 F10");
        System.out.println();
//        TODO: SHOW PRICE
//        System.out.println("Price: $7");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your password to confirm payment");
        System.out.println("(Type \"n\" to go back)");
        System.out.print(">> ");

        String password = scanner.nextLine();

        if (password.equalsIgnoreCase("n")) {
            return; // go back to previous menu
        }
        // TODO: CHECKING PASSWORD LOGIC HERE
//        ADD TO THE TICKET ARRAYLIST IN THE USER

    }
    public static void seat(){
        ClearScreen.clearScreen();
        System.out.println("  ___           _      ");
        System.out.println(" / __| ___ __ _| |_ ___");
        System.out.println(" \\__ \\/ -_) _` |  _(_-<");
        System.out.println(" |___/\\___\\__,_|\\__/__/");
        System.out.println();
//        TODO: SHOW MOVIE INFO & THEATRE INFO & STUDIO INFO & TIME INFO
//        System.out.println("Title 2");
//        System.out.println("Theatre Alpha | Studio 3");
//        System.out.println("14:25");
        System.out.println();
//        TODO: SHOW SEATS
//        System.out.println("A1 A2 A3 A4 A5     A6 A7 A8 A9 A10 A11 A12 A13 A14 A15     A16 A17 A18 A19 A20");
//        System.out.println("B1 B2 B3 B4 B5     B6 B7 B8 B9 B10 B11 B12 B13 B14 B15     B16 ### ### B19 B20");
//        System.out.println("C1 C2 C3 ## C5     C6 C7 C8 C9 C10 C11 ### ### C14 C15     C16 C17 C18 C19 C20");
//        System.out.println("D1 D2 D3 D4 D5     D6 D7 D8 D9 ### D11 D12 D13 D14 D15     D16 D17 D18 D19 D20");
//        System.out.println("E1 E2 E3 E4 E5     E6 E7 E8 ## ### ### ### E13 E14 E15     E16 E17 E18 E19 E20");
//        System.out.println("F1 F2 F3 F4 F5     F6 F7 F8 F9 F10 ### ### ### F14 F15     F16 F17 F18 F19 F20");
//        System.out.println("G1 G2 G3 G4 G5     G6 G7 G8 G9 G10 ### ### ### G14 G15     G16 G17 G18 G19 G20");
//        System.out.println("H1 H2 H3 H4 H5     H6 H7 H8 H9 H10 H11 H12 H13 H14 H15     H16 H17 H18 H19 H20");
//        System.out.println("I1 I2 I3 I4 I5     I6 I7 I8 I9 I10 I11 I12 I13 I14 I15     I16 I17 I18 I19 I20");
//        System.out.println("J1 J2 J3 J4 J5     J6 J7 J8 J9 J10 J11 J12 J13 J14 J15     J16 J17 J18 J19 J20");
        System.out.println();
        System.out.println("-------------------------------- Screen Area ---------------------------------");
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a Seat!");
        System.out.println("(Type \"n\" to go back)");
        System.out.println();

        System.out.println("How many seats do you want?");
        System.out.print(">> ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("n")) {
            return;
        }

        int seatCount;
        try {
            seatCount = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Invalid number!");
            return;
        }

        for (int i = 1; i <= seatCount; i++) {
            while (true) {
                System.out.println("\nPick seat " + i);
                System.out.print(">> ");
                String seat = scanner.nextLine();
                if (seat.equalsIgnoreCase("n")) {
                    return;
                }
                boolean available = !seat.equalsIgnoreCase("E9");
                if (!available) {
                    System.out.println("Seat is not available!");
                    continue;
                }
                break;
            }
        }

        System.out.println("\nAll seats selected!");
        showTicketTransaction();
    }
    public static void schedule(){
        ClearScreen.clearScreen();
        System.out.println(" _____ _ ");
        System.out.println(" |_ _(_) _ __ ___");
        System.out.println(" | | | | ' \\/ -_)");
        System.out.println(" |_| |_|_|_|_\\___|");
        System.out.println();
//        TODO: MOVIE TITLE & THEATRE NAME & STUDIO NAME
//        System.out.println("Title");
//        System.out.println("Theatre Alpha | Studio 3");
        System.out.println();
        System.out.println("Pick a Time! \n");
        System.out.println();
//        TODO: SHOW ALL AVAILABLE SCHEDULE
//        System.out.println("1. 11:30");
//        System.out.println("2. 14:25");
//        System.out.println("3. 17:20");
//        System.out.println("4. 20:15");
        System.out.println();
        System.out.println("(Type \"n\" to go back)");
        String schedule;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter schedule [xx:xx]");
            System.out.print(">> ");
            schedule = scanner.nextLine();
            if (!schedule.matches("^\\d{2}:\\d{2}$")) {
                System.out.println("Invalid format! Please use xx:xx (e.g., 14:25)");
                continue;
            }
//            TODO: CHECK IF SCHEDULE IS IN THE LIST
            if(schedule.equals("n")){
                return;
            }
            break; // TEMPORARY BREAK
        }
        seat();
    }
    public static void theatre(){
        ClearScreen.clearScreen();
        System.out.println("  _____ _             _              ");
        System.out.println(" |_   _| |_  ___ __ _| |_ _ _ ___ ___");
        System.out.println("   | | | ' \\/ -_) _` |  _| '_/ -_|_-<");
        System.out.println("   |_| |_||_\\___\\__,_|\\__|_| \\___/__/");
        System.out.println("                                     ");
//        TODO: DISPLAY MOVIE INFO
//        System.out.println("Title 2");
//        System.out.println("Director: Director 2 ");
//        System.out.println("Actors: Actor 1, Actor 2, Actor 3");
//        System.out.println("Genre: Sci-Fi");
//        System.out.println("Rating: PG-13");
//        System.out.println("Length: 169m");
        System.out.println();
        System.out.println("Pick a Theatre! ");
        System.out.println();
//        TODO: SHOW THEATRE LIST THAT SHOWS THE MOVIE
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
//            TODO: CHECK IF MOVIE IS IN THE LIST
            if(theatre.equals("n")){
                return;
            }
            break; // TEMPORARY BREAK
        }
        schedule();

    }
    public static void movie(){
        ClearScreen.clearScreen();
        System.out.println("  __  __         _        ");
        System.out.println(" |  \\/  |_____ _(_)___ ___");
        System.out.println(" | |\\/| / _ \\ V / / -_|_-<");
        System.out.println(" |_|  |_\\___/\\_/|_\\___/__/");
        System.out.println("                          ");
        System.out.println("Pick a Movie!");
        System.out.println();
//      TODO: SHOW MOVIE LIST
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
//           TODO: CHECK IF MOVIE IS IN THE LIST
            if(movie.equals("n")){
                return;
            }
            break; // TEMPORARY BREAK
        }
        theatre();
    }
    public static void viewTickets(){
        ClearScreen.clearScreen();
        System.out.println("  _____ _    _       _      ");
        System.out.println(" |_   _(_)__| |_____| |_ ___");
        System.out.println("   | | | / _| / / -_)  _(_-<");
        System.out.println("   |_| |_\\__|_\\_\\___|\\__/__/");
        System.out.println();
//        TODO: SHOW TICKET LIST
//        System.out.println("No\tMovie\t\t\tTheatre\t\tStudio\tTime\tSeat");
//        System.out.println("1\tTitle2\t\t\tTheatre Alpha\t3\t14:20\tF9 F10");
//        System.out.println("2\tNo Man Land\t\tTheatre Sigma\t3\t18:10\tF8");
        System.out.println();
        System.out.println();

    }
    public static void mainMenu(){
        ClearScreen.clearScreen();
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
                System.out.print("Enter to go back to main menu >>");
                scanner.nextLine();
                mainMenu();
                break;
            case 2:
                viewTickets();
                System.out.print("Enter to go back to main menu >>");
                scanner.nextLine();
                mainMenu();
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
