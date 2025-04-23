package com.pluralsight;

public class Book {
    //Properties
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    //Create an object in book
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    // Method to check out a book. When book is checked out the checkOutTo variable is set to the name and te isCheckOut variable is set to true
    public void checkOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
    }

    // Method to check in a book.When book is checked in the checkOutTo is set to "" and the isCheckOut variable is set to false.
    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
}
