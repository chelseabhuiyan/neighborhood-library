package com.pluralsight;

import java.util.Scanner;

public class Main {
    //Array to hold 20 books
    private static Book[] books = new Book[20];

    public static void main(String[] args) {
        // Initialize the books in the array
        initializeBooks();

        // Display the home screen menu
        displayMenu();
    }

    //Initialized 20 books
    private static void initializeBooks() {
        books[0] = new Book(0, "978-1-78862-355-1", "Nginx HTTP Server");
        books[1] = new Book(1, "978-1-4919-1889-0", "Learning React");
        books[2] = new Book(2, "978-0-13-468599-1", "Effective Java");
        books[3] = new Book(3, "978-1-4919-1881-4", "Fluent Python");
        books[4] = new Book(4, "978-1-59327-599-0", "Automate the Boring Stuff with Python");
        books[5] = new Book(5, "978-0-321-35668-0", "Clean Code");
        books[6] = new Book(6, "978-0-596-52068-7", "Head First Design Patterns");
        books[7] = new Book(7, "978-1-59327-950-9", "Black Hat Python");
        books[8] = new Book(8, "978-0-13-235088-4", "Clean Architecture");
        books[9] = new Book(9, "978-1-59327-424-5", "Hacking: The Art of Exploitation");
        books[10] = new Book(10, "978-0-13-110362-7", "The C Programming Language");
        books[11] = new Book(11, "978-1-59327-144-2", "The Linux Command Line");
        books[12] = new Book(12, "978-1-4919-1882-1", "Python Cookbook");
        books[13] = new Book(13, "978-1-4919-1885-2", "Designing Data-Intensive Applications");
        books[14] = new Book(14, "978-1-4493-6144-3", "You Don't Know JS");
        books[15] = new Book(15, "978-0-596-52068-7", "JavaScript: The Good Parts");
        books[16] = new Book(16, "978-1-4919-5600-7", "Site Reliability Engineering");
        books[17] = new Book(17, "978-1-4919-3412-8", "Kubernetes: Up & Running");
        books[18] = new Book(18, "978-0-321-93413-1", "Refactoring: Improving the Design of Existing Code");
        books[19] = new Book(19, "978-0-262-03384-8", "Introduction to Algorithms");
    }

    //Scanner to read in user input
    public static Scanner scanner = new Scanner(System.in);

    //The stores Home screen. It displays a list of options for the user to choose from
    private static void displayMenu() {
        while (true) {
            System.out.println(" Welcome to the Neighborhood Library");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    showCheckedOutBooks();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    //Show Available books method. It displays all the books checked out by showing its ID, ISBN, and Title.
    //User can choose to check out a book or go back to the Home Screen. If they check out a book they need to enter their name.
    private static void showAvailableBooks(){
        System.out.println("These are all the Books available");
        boolean anyBooksAvailable = false; //set to false at the start assuming there are no books available
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + " | ISBN: " + book.getIsbn() + " | Title: " + book.getTitle());
                anyBooksAvailable = true; //If one book is found that isn't checked out, then it is printed and the variable is set to true
            }
        }
        //If no books are available, end the method since no books can be checked out
        if (!anyBooksAvailable) {
            System.out.println("No books are currently available.");
            return;
        }
        //If there are available books, let the user choose the book by book ID
        System.out.print("\nEnter the ID of the book you want to check out (or 0 to go back): ");
        int bookId = scanner.nextInt();  //User enters book ID of book to check out
        scanner.nextLine(); // consume newline

        //Let them go back to the Home Screen if they don't want to check out a book.
        if (bookId == 0) {
            return; // Go back to menu
        }

        // Find the book with the matching ID that the user entered
        Book selectedBook = null; // create an object of book and set it to null
        for (Book book : books) {
            if (book.getId() == bookId && !book.isCheckedOut()) { //If we get book id and it matches the id the user inputed and it isn't checked out
                selectedBook = book;    //then we set our new object selectedBook to that book
                break; // end for loop and stop looking since we found the book
            }
        }
        // If a valid available book was found
        if (selectedBook != null) {
            System.out.print("Enter your name to check out the book: ");
            String userName = scanner.nextLine();  //User inputs their name
            selectedBook.checkOut(userName);  //Checkout the book under that name
            System.out.println("You have successfully checked out \"" + selectedBook.getTitle() + "\". Enjoy!");
        } else {
            System.out.println("Invalid book ID or the book is already checked out.");
        }
    }

    //Show Checked Out Books. This displays a list of all the books that are currently checked out by showing the ID, ISBN, Title, and name of who has it checked out.
    //User can choose to check in a book or go back to the home screen.
    private static void showCheckedOutBooks() {
        System.out.println("These books are currently checked out:");
        boolean anyCheckedOut = false;  //Set to false assuming none is checked out

        for (Book book : books) {
            if (book.isCheckedOut()) {  //See if any book is checked out. If one is found print and set the variable to true
                System.out.println("ID: " + book.getId() + " | ISBN: " + book.getIsbn() + " | Title: " + book.getTitle() + " | Checked out to: " + book.getCheckedOutTo());
                anyCheckedOut = true;
            }
        }

        //If no books are checked out, print that there are no books checked out currently.
        if (!anyCheckedOut) {
            System.out.println("No books are currently checked out.");
            return;
        }

        // Prompt user to check in a book or go back
        System.out.print("\nEnter 'C' to check in a book or 'X' to go back: ");
        String choice = scanner.nextLine().trim().toUpperCase(); //removes extra spaces and makes the letter uppercase

        if (choice.equals("C")) {
            System.out.print("Enter the ID of the book you want to check in: ");
            int bookId = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Book bookToCheckIn = null;
            for (Book book : books) {
                if (book.getId() == bookId && book.isCheckedOut()) { //If book id matches and is checked out, then set that book to the new object
                    bookToCheckIn = book;
                    break;
                }
            }

            //If book is found in the for loop, check it in
            if (bookToCheckIn != null) {
                bookToCheckIn.checkIn();
                System.out.println("Book \"" + bookToCheckIn.getTitle() + "\" has been checked in.");
            } else {
                System.out.println("Invalid ID or the book is not checked out.");
            }
        } else if (choice.equals("X")) {
            System.out.println("Returning to the main menu.");
            return;  //Go back to home screen if X is chosen
        } else {
            System.out.println("Invalid input. Returning to the main menu.");
            return; // Go back to the main menu if input is invalid
        }
    }
}
