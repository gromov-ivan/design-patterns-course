package main.java.visitor.file_system;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemElement element) {
        children.add(element);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement child : children) {
            child.accept(visitor);
        }
    }
}
