/*
Name: Alex Yuk
File: StableSelectionSort Class
Date: 11/5/2019
 */

public class StableSelectionSort extends SortAlg {

    public StableSelectionSort() {
    }

    public void sort(int[]list) {
        int min, temp;
        for (int i = 0; i < list.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < list.length; j++)
                if (list[min] > list[j])
                    min = j;
            temp = list[min];
            while (min > i) {
                list[min] = list[min - 1];
                min--;
            }
            list[i] = temp;
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
        int[] list = {2, 4, 3, 6, 5};
        SortAlg stableSelectionSort = new StableSelectionSort();

        stableSelectionSort.sort(list);
        printArray(list);
    }

}
