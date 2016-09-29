package sort;

import java.util.function.Predicate;

public class MergeSort extends AbstractSort {
    private int[] array;
    private int[] tempMergArr;
    private int length;
    private Predicate<int[]> predicate;

    @Override
    protected int[] sort(int[] array, Predicate<int[]> predicate) {
        this.array = array.clone();
        this.length = array.length;
        this.predicate = predicate;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
        return this.array;
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (predicate.test(new int[]{tempMergArr[i], tempMergArr[j]})) {
                array[k] = tempMergArr[j];
                j++;
            } else {
                array[k] = tempMergArr[i];
                i++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }
}
