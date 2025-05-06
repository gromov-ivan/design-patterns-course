package main.java.prototype.book_reccomendation_system;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final RecommendationRepository repo = new RecommendationRepository();

    public static void main(String[] args) {

        populateDatabase();

        while (true) {
            System.out.println("""
                    === Book Recommendation System ===
                    1) list recommendations
                    2) clone & modify a recommendation
                    3) create a new recommendation from scratch
                    0) exit
                    Choice:""");
            switch (sc.nextLine().trim()) {
                case "1" -> list();
                case "2" -> cloneAndModify();
                case "3" -> createNew();
                case "0" -> System.exit(0);
                default -> System.out.println("Unknown option. Try again.");
            }
        }
    }

    // Menu actions
    private static void list() {
        int i = 0;
        for (Recommendation r : repo.all()) {
            System.out.println("\n[" + i++ + "] " + r);
        }
        if (i == 0) System.out.println("(no data)\n");
    }

    private static void cloneAndModify() {
        list();
        System.out.print("Enter id to clone: ");
        int id = Integer.parseInt(sc.nextLine());
        Recommendation cloned = repo.get(id).clone();
        System.out.println("Cloned. Current state:\n" + cloned);

        System.out.print("Change audience? (blank to keep): ");
        String aud = sc.nextLine();
        if (!aud.isBlank()) cloned.setAudience(aud);

        System.out.print("Add a new book? (y/n): ");
        if (sc.nextLine().equalsIgnoreCase("y")) addBook(cloned);

        repo.save(cloned);
        System.out.println("Saved as a new recommendation.\n");
    }

    private static void createNew() {
        System.out.print("Audience: ");
        Recommendation rec = new Recommendation(sc.nextLine());

        do {
            addBook(rec);
            System.out.print("Add another? (y/n): ");
        } while (sc.nextLine().equalsIgnoreCase("y"));
        repo.save(rec);
        System.out.println("Saved.\n");
    }

    private static void addBook(Recommendation rec) {
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Title : ");
        String title = sc.nextLine();
        System.out.print("Genre : ");
        String genre = sc.nextLine();
        System.out.print("Year  : ");
        int year = Integer.parseInt(sc.nextLine());
        rec.addBook(new Book(author, title, genre, year));
    }

    private static void populateDatabase() {
        Recommendation teens = new Recommendation("Young Adults");
        teens.addBook(new Book("Suzanne Collins", "The Hunger Games", "Fiction", 2008));
        teens.addBook(new Book("John Green", "The Fault in Our Stars", "Fiction", 2012));
        repo.save(teens);

        Recommendation business = new Recommendation("Business");
        business.addBook(new Book("Jim Collins", "Good to Great", "Business", 2001));
        business.addBook(new Book("Peter Thiel", "Zero to One", "Business", 2014));
        repo.save(business);
    }
}
