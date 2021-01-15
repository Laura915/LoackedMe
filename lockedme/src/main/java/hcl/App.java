package hcl;

public class App 
{
    public static void main( String[] args )
    {
    	showWelcomeScreen();
    	showMainMenu();
    }
    //Build Main options screen
    private static void showMainMenu() {
        System.out.println("-- MAIN MENU --");
        System.out.println("1.) Show files in ascending order");
        System.out.println("2.) Perform file operations");
        System.out.println("3.) Close the application");
        System.out.println("---------------");
    }
   
    //Build Welcome screen
    private static void showWelcomeScreen() {
        System.out.println("---------------");
        System.out.println("Application: LockedMe.com");
        System.out.println("Developer: Laura Hernandez");
        System.out.println("---------------");
    }
    
}
