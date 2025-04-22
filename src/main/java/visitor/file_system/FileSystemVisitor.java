package main.java.visitor.file_system;

public interface FileSystemVisitor {
    void visit(File file);
    void visit(Directory directory);
}
