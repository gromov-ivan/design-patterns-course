package main.java.visitor.file_system;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");

        Directory docs = new Directory("docs");
        docs.add(new File("thesis.pdf", 5));
        docs.add(new File("notes.txt", 1));

        Directory pics = new Directory("pictures");
        pics.add(new File("cat.jpg", 2));
        pics.add(new File("dog.jpg", 3));

        root.add(docs);
        root.add(pics);
        root.add(new File("readme.md", 1));

        // Visitor 1: total size
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size of all files = " + sizeVisitor.getTotalMB() + "MB");

        // Visitor 2: search for .jpg files
        SearchVisitor jpgSearch = new SearchVisitor(file -> file.getName().toLowerCase().endsWith(".jpg"));
        root.accept(jpgSearch);

        System.out.println("JPEG files found:");
        jpgSearch.getMatches().forEach(f -> System.out.println("  • " + f.getName() + " (" + f.getSizeMB() + "MB)"));
    }
}
