package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RadixSort extends AbstractSort {

    private final int RADIX = 10;

    @Override
    protected int[] sort(int[] array, Predicate<int[]> predicate) {
        int[] resultArray = array.clone();

        List<Integer>[] bucket = new ArrayList[RADIX];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        boolean maxLength = false;
        int tmp, placement = 1;
        while (!maxLength) {
            maxLength = true;
            for (Integer i : resultArray) {
                if (i < 0) {
                    throw new NegativeNumberException();
                }
                tmp = i / placement;
                if (order==Order.ASK) {
                    bucket[tmp % RADIX].add(i);
                } else {
                    bucket[RADIX - 1 - tmp % RADIX].add(i);
                }
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    resultArray[a++] = i;
                }
                bucket[b].clear();
            }
            placement *= RADIX;
        }

        return resultArray;
    }
}
