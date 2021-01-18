package hcl;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App 
{
    static Scanner scanner = new Scanner(System.in);
    final static String FOLDER = "/tmp";
    
    public static void main( String[] args )
    {
    	showWelcomeScreen();
    	showMainMenu();
    }
    
    //Collects Main menu input option 
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
    
    //Collects file operations input option 
    private static void collectFileOperationsMenuOption() {
        System.out.println("Please choose your file operation:");
        String option = scanner.nextLine();
        switch (option) {
        case "1": //Adds a new file
        	addFile();
        	break;
        case "2": //deletes a file
        	deleteFile();
        	break;
        case "3": //search a file
        	searchFile();
        	break;
        case "4": //returns to main menu
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
    
    //Add file method
    private static void addFile() {
    	System.out.println("Please provide a file path:");
        String filePath = scanner.nextLine();
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            System.out.println("File does not exist");
            return;
        }

        String newFilePath = FOLDER + "/" + path.getFileName();
        int inc = 0;
        while (Files.exists(Paths.get(newFilePath))) {
            inc++;
            newFilePath = FOLDER + "/" + inc + "_" + path.getFileName();
        }
        try {
            Files.copy(path, Paths.get(newFilePath));
        } catch(IOException e) {
            System.out.println("Unable to copy file to " + newFilePath);
        }
        
    }
    
    //delete file method 
    private static void deleteFile() {
    	System.out.println("Please provide a file path :");
        String filePath = scanner.nextLine();
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            System.out.println("File does not exist");
            return;
        }
        try {
			Files.delete(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			  System.out.println("Unable to delete file to " + filePath);
		}
    }
    
    //searches file method 
    private static void searchFile() {
    	System.out.println("Please provide a file name:");
        String filePath = scanner.nextLine();
        Path path = Paths.get(filePath);
        
        if(!Files.exists(path)) {
			System.out.println("File not found!");
			return;
		} else {
			System.out.println("File Found! Path: " + filePath);
		}
        
        
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
