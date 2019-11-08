/*
Name: Alex Yuk
File: InsertionSort Class
Date: 11/5/2019
 */

public class InsertionSort extends SortAlg {

    public InsertionSort() {
    }

    public void sort(int[] list) {
        int temp, j;
        for (int i = 1; i < list.length; i++) {
            temp = list[i];
            j = i - 1;
            while (j >= 0 && list[j] > temp)
                list[j + 1] = list[j--];
            list[j + 1] = temp;
        }
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
        int[] list = {2, 4, 3, 6, 5, 6};
        SortAlg insertionSort = new InsertionSort();

        insertionSort.sort(list);
        printArray(list);
    }

}
