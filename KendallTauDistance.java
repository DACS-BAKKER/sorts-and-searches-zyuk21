/*
Name: Alex Yuk
File: Kendall Tau Distance
Date: 11/6/2019
 */

import edu.princeton.cs.algs4.*;

public class KendallTauDistance {

    private static int N = 10;

    // Returns Kendall Tau Distance of array a and array b
    public static int kendallTauDistance(int[] a, int[] b) {
        int[] aInversion = new int[N];
        for (int i = 0; i < N; i++)
            aInversion[a[i]] = i;

        int[] bNew = new int[N];
        for (int i = 0; i < N; i++)
            bNew[i] = aInversion[b[i]];

        return (int) Inversions.count(bNew);
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

    public static void main(String[] args) {
        System.out.print("Enter array size\n? ");
        N = StdIn.readInt();

        // Randomly generates two arrays
        int[] a = new int[N];
        int[] b = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = i;
            b[i] = i;
        }
        StdRandom.shuffle(a);
        StdRandom.shuffle(b);

        System.out.println("Initial Permutations:");
        System.out.print("Array a: ");
        printArray(a);
        System.out.print("Array b: ");
        printArray(b);

        System.out.println("Inversions: " + kendallTauDistance(a, b));
    }
}