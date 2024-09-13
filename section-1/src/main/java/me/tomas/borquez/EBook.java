package me.tomas.borquez;

public class EBook extends Book {
    int fileSize;

    public EBook(String title, String author, String ISBN, int fileSize) {
        super(title, author, ISBN);
        this.fileSize = fileSize;
    }

    @Override
    public String bookDetails() {
        return "Ebook{" +
                "fileSize=" + fileSize +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
