public class SelectionSort extends SortAlg {


    public SelectionSort() {
    }

    public void sort(int[] list) {
        int min, temp;
        for (int i = 0; i < list.length; i++) {
            min = i;
            for (int j = i + 1; j < list.length; j++)
                if (list[j] < list[min]) min = j;
            temp = list[i];
            list[i] = list[min];
            list[min] = temp;
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
        SortAlg selectionSort = new SelectionSort();

        selectionSort.sort(list);
        printArray(list);
    }

}
