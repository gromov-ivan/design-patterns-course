package main.java.strategy.performance_comparison;

public class SortingContext {
    private SortingStrategy strategy;

    public SortingContext() {
        strategy = new BubbleSort();
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] arr) {
        if (strategy == null) {
            throw new IllegalStateException("No sorting strategy set!");
        }
        strategy.sort(arr);
    }
}

