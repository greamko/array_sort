package sort;

import java.util.function.Predicate;

public class Selection extends AbstractSort {
    /**
     * Используем лямбду для проверки на больше/меньше
    * */
    protected int[] sort(int[] array, Predicate<int[]> predicate) {
        int[] resultArray = array.clone();
        int index, temp, counter = 0;

        for (; counter < resultArray.length; counter++) {
            index = counter;
            for (int i = counter; i < resultArray.length; i++) {
                if (predicate.test(new int[]{resultArray[index], resultArray[i]})) {
                    index = i;
                }
            }
            if (index != counter) {
                temp = resultArray[index];
                resultArray[index] = resultArray[counter];
                resultArray[counter] = temp;
            }
        }

        return resultArray;
    }
}
