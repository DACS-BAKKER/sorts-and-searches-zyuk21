/*
Name: Alex Yuk
File: Stack Compare Client
Date: 11/6/2019
 */

import edu.princeton.cs.algs4.StdIn;

public class StackCompareClient {
    public static void main(String[]args) {
        Stack<Integer> stack = new Stack<Integer>();
        ResizableArray arrStack = new ResizableArray();
        int N;

        System.out.println("All time shown in microseconds");
        System.out.print("Enter the number of elements added to each stack\n? ");
        N = StdIn.readInt();

        long beforeTime, afterTime;

        System.out.println("Pushing " + N + " values:");
        beforeTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        afterTime = System.nanoTime();
        System.out.println("Linked List Stack Time: " + (afterTime - beforeTime) / 1000);

        beforeTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            arrStack.push(i);
        }
        afterTime = System.nanoTime();
        System.out.println("Resizeable Array Stack Time: " + (afterTime - beforeTime) / 1000);


        System.out.println("\nPopping " + N + " values:");
        beforeTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            stack.pop();
        }
        afterTime = System.nanoTime();
        System.out.println("Linked List Stack Time: " + (afterTime - beforeTime) / 1000);

        beforeTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            arrStack.pop();
        }
        afterTime = System.nanoTime();
        System.out.println("Resizeable Array Stack Time: " + (afterTime - beforeTime) / 1000);
    }
}
