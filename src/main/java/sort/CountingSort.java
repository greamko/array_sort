package sort;

import java.util.function.Predicate;

public class CountingSort extends AbstractSort {

    @Override
    protected int[] sort(int[] array, Predicate<int[]> predicate) {
        int[] resultArray = new int[array.length];
        int subArraySize = array[0];
        for (int item : array) {
            if (item < 0) {
                throw new NegativeNumberException();
            }
            if (subArraySize < item) {
                subArraySize = item;
            }
        }
        int[] subArray = new int[++subArraySize];
        for (int item : array) {
            subArray[item]++;
        }
        int index = 0;
        for (int i = 0; i<subArraySize; i++) {
            while (subArray[i] != 0) {
                /*по возрастанию или убыванию*/
                if (order==Order.ASK) {
                    resultArray[index] = i;
                } else {
                    resultArray[array.length - index - 1] = i;
                }
                index++;
                subArray[i]--;
            }
        }
        return resultArray;
    }
}
