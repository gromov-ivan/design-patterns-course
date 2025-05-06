package main.java.prototype.book_reccomendation_system;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {

    private String targetAudience;
    private final List<Book> books = new ArrayList<>();

    public Recommendation(String audience) {
        this.targetAudience = audience;
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void removeBook(int index) {
        books.remove(index);
    }

    public String getAudience() {
        return targetAudience;
    }

    public void setAudience(String a) {
        this.targetAudience = a;
    }

    public List<Book> getBooks() {
        return books;
    }

    // Prototype deep‑clone
    @Override
    public Recommendation clone() {
        try {
            Recommendation copy = (Recommendation) super.clone();
            // deep copy of a list
            copy.books.clear();
            for (Book b : this.books) {
                copy.books.add(b.clone());
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Target audience: " + targetAudience + "\n");
        int i = 1;
        for (Book b : books) sb.append("  ").append(i++).append(". ").append(b).append('\n');
        return sb.toString();
    }
}

