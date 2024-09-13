package me.tomas.borquez;

public class BookFactory {
    public Book createBook(String title, String author, String ISBN) {
        return new Book(title, author, ISBN);
    };

    public EBook createEBook(String title, String author, String ISBN, int fileSize) {
        return new EBook(title, author, ISBN, fileSize);
    }

    public AudioBook createAudioBook(String title, String author, String ISBN, int length) {
        return new AudioBook(title, author, ISBN, length);
    }
}
