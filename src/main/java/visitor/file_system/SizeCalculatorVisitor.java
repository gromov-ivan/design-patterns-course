package main.java.visitor.file_system;

public class SizeCalculatorVisitor implements FileSystemVisitor {

    private int totalMB = 0;

    @Override
    public void visit(File file) {
        totalMB += file.getSizeMB();
    }

    @Override
    public void visit(Directory directory) {
    }

    public int getTotalMB() { return totalMB; }
}
