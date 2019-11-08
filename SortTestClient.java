/*
Name: Alex Yuk
File: SortTestClient
Date: 11/5/2019
 */

import edu.princeton.cs.algs4.*;

public class SortTestClient {

    private static final int NUM_OF_SORTS = 7;

    private static Alg[] algList;
    private static int N;
    private static int REPETITIONS;
    private static int[] randomArr;

    enum Alg {
        Insertion, Selection, Merge, Quick, Radix, StableSelection, BlockSort
    }

    public static void main(String[]args) {
        init();
        runSorts();
    }

    private static void runSorts() {
        for (Alg currentAlgEnum: algList) {
            if (currentAlgEnum == Alg.BlockSort) continue; // Block Sort still work in progress...
            sort(currentAlgEnum);
        }
    }

    private static void sort(Alg currentAlgEnum) {
        long beforeTime, afterTime, totalTime = 0;
        SortAlg currentAlg;
        switch(currentAlgEnum) {
            case Insertion:
                currentAlg = new InsertionSort();
                break;
            case Selection:
                currentAlg = new SelectionSort();
                break;
            case Merge:
                currentAlg = new MergeSort();
                break;
            case Quick:
                currentAlg = new QuickSort();
                break;
            case Radix:
                currentAlg = new RadixSort();
                break;
            case StableSelection:
                currentAlg = new StableSelectionSort();
                break;
            case BlockSort:
            default:
                currentAlg = new BlockSort();
                break;
        }

        System.out.println("Current Sort: " + currentAlgEnum);

        for (int i = 0; i < REPETITIONS; i++) {
            for (int j = 0; j < N; j++)
                randomArr[j] = (int) (Math.random() * N);

            if (N <= 10 && REPETITIONS <= 5){
                System.out.print("Random: ");
                printArray(randomArr);
            }

            beforeTime = System.nanoTime();
            currentAlg.sort(randomArr);
            afterTime = System.nanoTime();
            totalTime += afterTime - beforeTime;

            if (N <= 10 && REPETITIONS <= 5) {
                System.out.print("Sorted: ");
                printArray(randomArr);
            }
        }

        System.out.println("Average Time Taken (microseconds): " + (totalTime) / REPETITIONS / 1000 + "\n");
    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("");
    }

    public static void init() {
        algList = new Alg[NUM_OF_SORTS];
        algList[0] = Alg.Insertion;
        algList[1] = Alg.Selection;
        algList[2] = Alg.Merge;
        algList[3] = Alg.Quick;
        algList[4] = Alg.Radix;
        algList[5] = Alg.StableSelection;
        algList[6] = Alg.BlockSort;

        System.out.println("If number of elements (N) <= 10 and number of repetitions (REPETITIONS) <= 5\nRandom list and sorted list for each repetition will be printed\n");
        System.out.print("Enter N\n? ");
        N = StdIn.readInt();
        randomArr = new int[N];
        System.out.print("Enter REPETITION\n? ");
        REPETITIONS = StdIn.readInt();
        System.out.println("");
    }
}

