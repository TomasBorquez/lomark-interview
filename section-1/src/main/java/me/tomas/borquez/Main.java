package me.tomas.borquez;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addAudioBook("Java Fundamentals", "Tomas Borquez", "123-456-789", 10_000);
        library.addEBook("Design Patterns", "Tomas Borges", "987-654-321", 132);

        System.out.println(library.getBook(0).bookDetails());
        System.out.println(library.getBook(1).bookDetails());
    }
}