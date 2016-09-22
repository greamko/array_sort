package sort;

import java.util.function.Predicate;

public class BubbleSort extends AbstractSort {

    protected int[] sort(int[] array, Predicate<int[]> predicate) {
        int[] resultArray = array.clone();
        boolean isMoved = true;
        int temp;
        while (isMoved) {
            isMoved = false;
            for (int i = 1; i < resultArray.length; i++) {
                if (predicate.test(new int[]{resultArray[i - 1], resultArray[i]})) {
                    temp = resultArray[i];
                    resultArray[i] = resultArray[i - 1];
                    resultArray[i - 1] = temp;
                    isMoved = true;
                }
            }
        }
        return resultArray;
    }
}
