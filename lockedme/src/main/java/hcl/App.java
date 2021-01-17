package hcl;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;

public class App 
{
    static Scanner scanner = new Scanner(System.in);
    final static String FOLDER = "/tmp";
    
    public static void main( String[] args )
    {
    	showWelcomeScreen();
    	showMainMenu();
    }
    
    //Collects users input option 
    private static void collectMainMenuOption() {
        System.out.println("Please choose your file operation:");
        String option = scanner.nextLine();
        switch (option) {
        case "1": //Show files in ascending order
        	showFilesInAscendingOrder();
        	break;
        case "2": //Show file operations menu screen
        	showFileOperationsMenu();
        	break;	   	
        case "3": //Closes application
            System.out.println("Thanks for using lockedme.com. Closing application.");
            System.exit(0);
            break;
        default: //Invalid input control
            System.out.println("Invalid input provided, please choose from available options");
            break;
    }
    showMainMenu();
        
    }
    
    private static void collectFileOperationsMenuOption() {
        System.out.println("Please choose your file operation:");
        String option = scanner.nextLine();
        switch (option) {
        case "4": //Returns to main menu
        	showMainMenu();
        	break;
        default: //Invalid input control
            System.out.println("Invalid input provided, please choose from available options");
            break;
    }
        showFileOperationsMenu();   
    }
    
    //Show files in ascending order    
    private static void showFilesInAscendingOrder() {
        System.out.println("------------------");
        System.out.println("Showing files in ascending order");
        File[] files = new File(FOLDER).listFiles();
        Set<String> sorted = new TreeSet<>();
        for (File file: files) {
            if (!file.isFile()) {
                continue;
            }
            sorted.add(file.getName());
        }
        sorted.forEach(System.out::println);
        System.out.println("------------------");
    }
    
    //Build file operations screen
    private static void showFileOperationsMenu() {
    	System.out.println("---------------");
        System.out.println("-- File Operations MENU --");
        System.out.println("1.) Add a File");
        System.out.println("2.) Delete a File");
        System.out.println("3.) Search a file");
        System.out.println("4.) Navigate back to main menu");
        System.out.println("---------------");
        collectFileOperationsMenuOption();
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
