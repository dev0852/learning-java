public class quicksort {

    public static void quicksort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int p = partition(a, lo, hi);
            quicksort(a, lo, p - 1);
            quicksort(a, p + 1, hi);
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, hi);
        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        quicksort(arr, 0, arr.length-1);
        for(int i : arr) {
            System.out.println(i);
        }
    }
}
