package main.java.visitor.file_system;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchVisitor implements FileSystemVisitor {

    private final Predicate<File> matcher;
    private final List<File> matches = new ArrayList<>();

    public SearchVisitor(Predicate<File> matcher) {
        this.matcher = matcher;
    }

    @Override
    public void visit(File file) {
        if (matcher.test(file)) {
            matches.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
    }

    public List<File> getMatches() { return matches; }
}

