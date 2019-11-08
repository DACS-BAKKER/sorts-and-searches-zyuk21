/*
Name: Alex Yuk
File: ResizeableArrayStack
Date: 11/5/2019
 */

public class ResizableArray {

    private int[] array;
    private int topIndex;
    private int trueSize;

    public ResizableArray() {
        array = new int[2];
        trueSize = 2;
        topIndex = 0;
    }

    public int peek() {
        return array[topIndex];
    }

    public void push(int element) {
        if (topIndex >= trueSize) {
            resize(trueSize * 2);
            trueSize *= 2;
        }
        array[topIndex] = element;
        topIndex++;
    }

    public int pop() {
        if (topIndex < (trueSize / 4)) {
            resize(trueSize / 4);
            trueSize /= 4;
        }
        topIndex--;

        return array[topIndex];
    }

    private void resize(int newSize) {
        int[] temp = new int[newSize];
        for (int i = 0; i < topIndex; i++)
            temp[i] = array[i];
        array = temp;
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < topIndex; i++)
            if(i == topIndex - 1) str += array[i] + ", ";
            else str += array[i];
        str += "]";
        return str;
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
        ResizableArray rarr = new ResizableArray();

        for (int i = 0; i < 10; i++) {
            rarr.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Index: " + rarr.topIndex + "\tSize: " + rarr.trueSize + "\tPop: " + rarr.pop());
        }

    }
}
