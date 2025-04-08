package main.java.strategy.performance_comparison;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        SortingContext context = new SortingContext();

        System.out.println("SMALL DATASET (e.g. 30 elements)");
        int[] smallArray = createRandomArray(30);

        testStrategy("BubbleSort", new BubbleSort(), smallArray);
        testStrategy("MergeSort", new MergeSort(), smallArray);
        testStrategy("QuickSort", new QuickSort(), smallArray);

        System.out.println("\nLARGE DATASET (e.g. 100,000 elements)");
        int[] largeArray = createRandomArray(100_000);

        testStrategy("BubbleSort", new BubbleSort(), largeArray);
        testStrategy("MergeSort", new MergeSort(), largeArray);
        testStrategy("QuickSort", new QuickSort(), largeArray);
    }

    private static void testStrategy(String strategyName, SortingStrategy strategy, int[] originalArray) {
        int[] arrayToSort = originalArray.clone();

        SortingContext context = new SortingContext();
        context.setStrategy(strategy);

        long startTime = System.nanoTime();
        context.sortArray(arrayToSort);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println(strategyName + " took " + (duration / 1_000_000.0) + " ms");
    }

    private static int[] createRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1_000_000);
        }
        return array;
    }
}

