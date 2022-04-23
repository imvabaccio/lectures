class App {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int maximum = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[maximum]) {
            maximum = left;
        }

        if (right < n && arr[right] > arr[maximum]) {
            maximum = right;
        }

        // swap

        if (maximum != i) {
            int temp = arr[i];
            arr[i] = arr[maximum];
            arr[maximum] = temp;

            heapify(arr, n, maximum);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) throws Exception {
        int[] arr = { 10, 20, 3, 1, 0, 5, 2 };

        printArray(arr);

        heapSort(arr);

        printArray(arr);
    }
}

class HeapSort {

}
