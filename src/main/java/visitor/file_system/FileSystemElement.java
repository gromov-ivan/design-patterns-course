package main.java.visitor.file_system;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
    String getName();
}
