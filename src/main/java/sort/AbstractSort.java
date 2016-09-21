package sort;

import java.util.function.Predicate;

public abstract class AbstractSort implements Sorting {
    public int[] sort(int[] array) {
        return this.sortAsk(array);
    }

    public int[] sort(int[] array, Order order) {
        switch (order){
            case DESK:
                return sortDesk(array);
            default:
                return sortAsk(array);
        }
    }

    protected int[] sortAsk(int[] array) {
        return sort(array, (a) -> a[0] > a[1]);
    }

    protected int[] sortDesk(int[] array) {
        return sort(array, (a) -> a[0] < a[1]);
    }

    protected abstract int[] sort(int[] array, Predicate<int[]> predicate);
}
