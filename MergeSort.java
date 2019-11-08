/*
Name: Alex Yuk
File: MergeSort Class
Date: 11/5/2019
 */

public class MergeSort extends SortAlg {

    private int[] list;

    public MergeSort() {
    }

    public void sort(int[] list) {
        this.list = new int[list.length];
        sort(list, 0, list.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (right <= left)
            return;
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k;

        for (k = left; k <= right; k++)
            list[k] = arr[k];

        for (k = left; k <= right; k++) {
            if (i > mid)
                arr[k] = list[j++];
            else if (j > right)
                arr[k] = list[i++];
            else if
                (list[j] < list[i]) arr[k] = list[j++];
            else
                arr[k] = list[i++];
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] list = {2, 4, 3, 6, 5, 6, 4, 1, 2, 3, 9, 74};

        SortAlg mergeSort = new MergeSort();

        mergeSort.sort(list);
        printArray(list);
    }
}
