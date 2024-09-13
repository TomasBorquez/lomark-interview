package me.tomas.borquez;

public class AudioBook extends Book {
    int length;

    public AudioBook(String title, String author, String ISBN, int length) {
        super(title, author, ISBN);
        this.length = length;
    }

    @Override
    public String bookDetails() {
        return "Audiobook{" +
                "length=" + length +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
