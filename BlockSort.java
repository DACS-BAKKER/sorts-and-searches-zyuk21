public class BlockSort extends SortAlg {

    private static final int N = 32;

    public BlockSort() {
    }

    public static void insertionSort(int[] list, int left, int right) {
        int temp, j;
        for (int i = left + 1; i < right - 1; i++) {
            temp = list[i];
            j = i - 1;
            while (j >= left && list[j] > temp)
                list[j + 1] = list[j--];
            list[j + 1] = temp;
        }
    }

    // Iterative Merge Sort
    public static void merge(int[] arr, int left, int mid, int right) {
        // Array broken into two parts

        int leftLength = mid - left + 1;
        int rightLength = Math.abs(right - mid);

        System.out.println("leftLength: "+ leftLength + " rightLength: " + rightLength);

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        int i;
        // Copy leftArray and rightArray from arr
        for (i = 0; i < leftLength; i++)
            leftArray[i] = arr[left + i];
        for (i = 0; i < rightLength; i++)
            rightArray[i] = arr[mid + 1 + i];

        i = 0;
        int j = 0;
        int k = left;

        // Merge after comparing
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j])
                arr[k++] = leftArray[i++];
            else
                arr[k++] = rightArray[j++];
        }

        // Adding leftovers
        while (i < leftLength)
            arr[k++] = leftArray[i++];
        while (j < rightLength)
            arr[k++] = rightArray[j++];
    }



    // Iterative Block Sort
    public void sort(int[] arr) {

        int arrLength = arr.length;

        // Sort sub arrays of size N with insertion sort
        for (int i = 0; i < arrLength; i += N)
            insertionSort(arr, i, Math.min((i + N - 1), (arrLength - 1)));

        // size is to keep track of the index of each sub array
        int size, left, mid, right;

        // Merge previously sorted sub arrays
        for (size = N; size < arrLength; size *= 2) {

            System.out.println(size);

            // Keep merging all of the sub arrays by increasing left by 2 * size
            for (left = 0; left < arrLength; left += 2 * size) {

                // mid + 1 is starting point of right array
                mid = left + size - 1;
                System.out.println((left + 2 * size - 1) + " " + (arrLength - 1)) ;
                right = Math.min((left + 2 * size - 1), (arrLength - 1));

                System.out.println("Left: " + left + " Right: " + right + " Mid: " + mid);

                // Merge array left to mid and array mid to right
                merge(arr, left, mid, right);
            }
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
//        int[] list = new int[1000];
//        for (int i = 1000; i > 0; i--){
//            list[1000 - i] = i;
//        }
//

        int[] list = {2, 4, 3, 6, 5, 6, 4, 1, 2, 3, 9, 74, 123,4,12,4,6,1,123,4,5,8,4,8,9,53,213,4,6,234,12,3,5,456,1,2,34,1,2,4,6,78,89,8,6,56,7,56,5,45,456,3456,3456,654,3456,5,678,758,978,567,4567,3456,45,2345,3,231,1342,4563,64,758,5678,46,3645,345,23,546};

        SortAlg blockSort = new BlockSort();

        blockSort.sort(list);
        printArray(list);
    }
}
