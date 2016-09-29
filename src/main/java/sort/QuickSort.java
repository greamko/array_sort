package sort;

import java.util.function.Predicate;

public class QuickSort extends AbstractSort {

    int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            if(order==Order.ASK) {
                while (arr[i] < pivot) {
                    i++;
                }
                while (arr[j] > pivot) {
                    j--;
                }
            }
            else {
                while (arr[i] > pivot) {
                    i++;
                }
                while (arr[j] < pivot) {
                    j--;
                }
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    @Override
    protected int[] sort(int[] array, Predicate<int[]> predicate) {
        int[] resultArray = array.clone();
        quickSort(resultArray, 0, array.length - 1);
        return resultArray;
    }
}
