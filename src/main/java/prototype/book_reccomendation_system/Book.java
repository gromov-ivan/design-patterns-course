package main.java.prototype.book_reccomendation_system;

public class Book implements Cloneable {

    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int year) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    protected Book clone() {
        try {
            return (Book) super.clone();   // shallow copy
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "\"%s\" by %s (%d, %s)".formatted(title, author, publicationYear, genre);
    }
}
