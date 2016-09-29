package sort;

import java.util.function.Predicate;

public abstract class AbstractSort implements Sorting {

    protected Order order;

    public int[] sort(int[] array) {
        return sort(array, Order.ASK);
    }

    public int[] sort(int[] array, Order order) {
        this.order = order;
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

    /**
     * Используем лямбду для проверки на больше/меньше
     * */
    protected abstract int[] sort(int[] array, Predicate<int[]> predicate);
}
