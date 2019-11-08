/*
Name: Alex Yuk
File: Birthday Problem
Date: 11/5/2019
 */

import edu.princeton.cs.algs4.StdIn;

public class BirthdayProblem {
    public static void main(String[] args) {

        int N, REPETITIONS;

        System.out.print("Enter N (Number of elements)\n? ");
        N = StdIn.readInt();
        System.out.print("Enter REPETITION\n? ");
        REPETITIONS = StdIn.readInt();
        int counter = 0;

        for (int i = 0; i < REPETITIONS; i++) {
            boolean[] birthday = new boolean[N];
            boolean isRepeated = false;
            while (!isRepeated) {
                counter++;
                int r = (int) (Math.random() * N);
                if (birthday[r])
                    isRepeated = true;
                else
                    birthday[r] = true;
            }
        }

        System.out.println("Experimental: " + (double) counter / REPETITIONS);
        System.out.println("Theoretical: " + Math.sqrt(N * Math.PI / 2));
    }
}
