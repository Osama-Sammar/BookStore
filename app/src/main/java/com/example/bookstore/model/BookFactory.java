package com.example.bookstore.model;

public class BookFactory {

    public IBookDa getModel(){
        // if statement to check the internet connection

        return new BookDa();
    }
}
