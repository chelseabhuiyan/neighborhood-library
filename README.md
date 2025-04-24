# neighborhood-library

## Project Description

Welcome to the **Neighborhood Library**! This is a simple, honor-system-based application that allows users to check out and check in books from a community library. The library is completely free and relies on the honor system, where anyone can borrow books by simply entering their name. The application tracks which books are checked out and who has them.

The library is built using Java and contains an array of at least 20 books. It provides a simple text-based interface for interacting with the system.

## Features

- **Book Class**: A class to manage books with properties such as `id`, `isbn`, `title`, `isCheckedOut`, and `checkedOutTo`. The class has methods for checking out and checking in books.
- **Main Menu**: Displays options for users to either view available books, view checked-out books, or exit the application.
- **Available Books**: Displays a list of books that are currently available to check out.
- **Checked-Out Books**: Displays a list of books that have been checked out and by whom.
- **Book Checkout/Checkin**: Allows users to check out a book by entering their name and check it back in when they're done.

## Requirements

- **Book Class**: 
  - Properties:
    - `id` (int): Unique identifier for the book.
    - `isbn` (String): ISBN number of the book.
    - `title` (String): Title of the book.
    - `isCheckedOut` (boolean): Indicates if the book is currently checked out.
    - `checkedOutTo` (String): The name of the person who has checked out the book.
  - Methods:
    - `checkOut(name)`: Marks the book as checked out and records the name of the person who checked it out.
    - `checkIn()`: Marks the book as returned and clears the name of the person who checked it out.

- **Array of Books**: 
  - The library stores a list of at least 20 books, each with a unique ID, ISBN, and title.

- **User Interaction**:
  - Home screen menu with options to:
    - Show Available Books.
    - Show Checked Out Books.
    - Exit the application.
  - Ability to:
    - Check out a book by selecting its ID and entering a name.
    - Check in a book by entering its ID.
  
## How It Works

1. **Main Menu**: 
   - The application presents a main menu where users can choose between available options.
   
2. **Show Available Books**: 
   - Displays a list of books that are available to borrow.
   - Users can select a book to check out or return to the main menu.
   
3. **Show Checked Out Books**: 
   - Displays a list of books that are currently checked out, along with the name of the person who checked it out.
   - Users can either check in a book or return to the main menu.
   
4. **Check Out/Check In**: 
   - Users can check out a book by providing their name and selecting a book ID from the list of available books.
   - Users can return a book by providing the book ID from the list of checked-out books.


## Interesting Piece of Code 

public void checkOut(String name) {
    if (!isCheckedOut) {
        isCheckedOut = true;
        checkedOutTo = name;
    } else {
        System.out.println("This book is already checked out.");
    }
}

#### This is interesting because this method in the Book class ensures that a book can only be checked out if it’s currently available, preventing errors like double-checking out a book. It’s an example of using encapsulation to protect object data and control behavior logically.

## Screen Shots

### Home Screen
[HomeScreen](screenshots/neighborhood-library_homescreen.png)

### Product Display Screen
[Product Display](screenshots/neighborhood-library_avaliableBooks.png)

### An error input and Error Screen
[Error1](screenshots/neighborhood-library_error1.png)

[Error2](screenshots/neighborhood-library_error2.png)
