package sort;

import java.util.function.Predicate;

public class HeapSort extends AbstractSort {

    Predicate<int[]> predicate;

    @Override
    protected int[] sort(int[] array, Predicate<int[]> predicate) {
        this.predicate = predicate;
        int[] resultArray = array.clone();
        int N = resultArray.length;

        for (int k = N / 2; k > 0; k--) {
            downheap(resultArray, k, N);
        }

        do {
            int T = resultArray[0];
            resultArray[0] = resultArray[N - 1];
            resultArray[N - 1] = T;

            N = N - 1;
            downheap(resultArray, 1, N);

        } while (N > 1);

        return resultArray;
    }

    void downheap(int array[], int k, int N) {

        int T = array[k - 1];

        while (k <= N / 2) {
            int j = k + k;

            if ((j < N) && predicate.test(new int[]{array[j], array[j - 1]})) {
                j++;
            }

            if (predicate.test(new int[]{T, array[j - 1]})) {
                break;
            } else {
                array[k - 1] = array[j - 1];
                k = j;
            }
        }
        array[k - 1] = T;
    }
}
