package com;

import java.util.Scanner;

public class UserMenu {
    private static final Scanner input = new Scanner(System.in);

    public static void printWelcomeMessage() {
        System.out.println("==================================================");
        System.out.println("Welcome to LockedMe.com");
        System.out.println("Developer: Aayush Kashyap");
        System.out.println("==================================================\n");
    }

    public static void launchMainMenu() {
        boolean continueApp = true;

        while (continueApp) {
            System.out.println("\n MAIN MENU:");
            System.out.println("1. View all stored files");
            System.out.println("2. File operations (Add, Delete, Search)");
            System.out.println("3. Exit application");

            System.out.print("Enter your choice (1-3): ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    FileUtility.listAllFiles();
                    break;
                case "2":
                    openFileOperationsMenu();
                    break;
                case "3":
                    System.out.println("👋 Exiting application. Have a great day, Anas!");
                    continueApp = false;
                    break;
                default:
                    System.out.println("❗ Invalid input. Please choose a valid option.");
            }
        }
    }

    private static void openFileOperationsMenu() {
        boolean stayInMenu = true;

        while (stayInMenu) {
            System.out.println("\n⚙️  FILE OPERATIONS:");
            System.out.println("1. ➕ Add a new file");
            System.out.println("2. ➖ Delete an existing file");
            System.out.println("3. 🔍 Search for a file");
            System.out.println("4. 🔙 Return to main menu");

            System.out.print("Choose an option (1-4): ");
            String operation = input.nextLine().trim();

            switch (operation) {
                case "1":
                    System.out.print("Enter filename to add: ");
                    FileUtility.addNewFile(input.nextLine().trim());
                    break;
                case "2":
                    System.out.print("Enter filename to delete: ");
                    FileUtility.deleteFile(input.nextLine().trim());
                    break;
                case "3":
                    System.out.print("Enter filename to search: ");
                    FileUtility.searchFile(input.nextLine().trim());
                    break;
                case "4":
                    stayInMenu = false;
                    break;
                default:
                    System.out.println("❗ Invalid option. Try again.");
            }
        }
    }
}
