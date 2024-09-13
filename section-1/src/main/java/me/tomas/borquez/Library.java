package me.tomas.borquez;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final BookFactory bookFactory = new BookFactory();

    public void addEBook(String title, String author, String ISBN, int fileSize) {
        books.add(bookFactory.createEBook(title, author, ISBN, fileSize));
    }

    public void addAudioBook(String title, String author, String ISBN, int length) {
        books.add(bookFactory.createAudioBook(title, author, ISBN, length));
    }

    public Book getBook(int index) {
        return books.get(index);
    }
}
