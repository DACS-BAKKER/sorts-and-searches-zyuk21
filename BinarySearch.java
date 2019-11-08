/*
Name: Alex Yuk
File: BinarySearch
Date: 11/5/2019
 */

import edu.princeton.cs.algs4.StdIn;

public class BinarySearch {

    private static final int N = 20;

    public static void main(String[] args) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = (int) (Math.random() * N);
        SortAlg insertionSort = new InsertionSort();
        insertionSort.sort(arr);

        System.out.println("Sorted randomly generated array of " + N + " numbers");
        printArray(arr);

        System.out.print("Which number would you like to locate the first iteration of\n? ");
        int userInput = StdIn.readInt();

        int location = binarySearch(arr, userInput, 0, arr.length - 1);

        System.out.println(location);
        if (location == -1)
            System.out.println("Your number is not in the array");
        else
            System.out.println("Your number is at index " + location);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++)
            if(i != arr.length - 1)
                System.out.print(arr[i] + ", ");
            else
                System.out.print(arr[i]);
        System.out.println("]");
    }

    private static int binarySearch(int[] arr, int target, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target)
                return binarySearch(arr, target, left, mid - 1);
            return binarySearch(arr, target, mid + 1, right);
        }
        return -1;
    }
}
