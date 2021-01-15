package hcl;

import java.util.Scanner;

public class App 
{
    static Scanner scanner = new Scanner(System.in);
    
    public static void main( String[] args )
    {
    	showWelcomeScreen();
    	showMainMenu();
    }
    
    //Collects users input option 
    private static void collectMainMenuOption() {
        System.out.println("Please choose 1, 2 or 3:");
        String option = scanner.nextLine();
        switch (option) {
        case "3": //Closes application
            System.out.println("Thanks for using lockedme.com. Closing application.");
            System.exit(0);
            break;
        default: //Invalid input control
            System.out.println("Invalid input provided, please choose 1, 2 or 3.");
            break;
    }
    showMainMenu();
        
    }
    
    //Build Main options screen
    private static void showMainMenu() {
        System.out.println("-- MAIN MENU --");
        System.out.println("1.) Show files in ascending order");
        System.out.println("2.) Perform file operations");
        System.out.println("3.) Close the application");
        System.out.println("---------------");
        collectMainMenuOption();
    }
   
    //Build Welcome screen
    private static void showWelcomeScreen() {
        System.out.println("---------------");
        System.out.println("Application: LockedMe.com");
        System.out.println("Developer: Laura Hernandez");
        System.out.println("---------------");
    }
    
}
