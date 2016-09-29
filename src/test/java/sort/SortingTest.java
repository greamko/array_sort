package sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SortingTest {

    private Sorting sorting;

    public SortingTest(Sorting sorting) {
        this.sorting = sorting;
    }

    @Test
    public void case01() {
        int[] testArray = {4, 12, 32, 1, 8, 2, 20};
        int[] expectedArray = {1, 2, 4, 8, 12, 20, 32};
        simpleSelection(testArray, expectedArray, Order.ASK);
    }

    @Test
    public void case02() {
        int[] testArray = {4, -1, 32, 1, 8, -20, 20};
        int[] expectedArray = {-20, -1, 1, 4, 8, 20, 32};
        simpleSelection(testArray, expectedArray, Order.ASK);
    }

    @Test
    public void case03() {
        int[] testArray = {4, -1, 32, 1, 8, -20, 1, 20};
        int[] expectedArray = {-20, -1, 1, 1, 4, 8, 20, 32};
        simpleSelection(testArray, expectedArray, Order.ASK);
    }

    @Test
    public void case04() {
        int[] testArray = {4, 12, 32, 1, 8, 2, 20};
        int[] expectedArray = {32, 20, 12, 8, 4, 2, 1};
        simpleSelection(testArray, expectedArray, Order.DESK);
    }

    @Test
    public void case05() {
        int[] testArray = {4, -1, 32, 1, 8, -20, 20};
        int[] expectedArray = {32, 20, 8, 4, 1, -1, -20};
        simpleSelection(testArray, expectedArray, Order.DESK);
    }

    @Test
    public void case06() {
        int[] testArray = {4, -1, 32, 1, 8, -20, 1, 20};
        int[] expectedArray = {32, 20, 8, 4, 1, 1, -1, -20};
        simpleSelection(testArray, expectedArray, Order.DESK);
    }

    void simpleSelection(int[] testArray, int[] expectedArray, Order order) {
        try {
            int[] resultArray = sorting.sort(testArray, order);
            Assert.assertArrayEquals(expectedArray, resultArray);
            System.out.println("in: " + Arrays.toString(testArray));
            System.out.println("out: " + Arrays.toString(expectedArray));
            System.out.println("everything is ok");
        } catch (NegativeNumberException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Sorting> instancesToTest() {
        return Arrays.asList((Sorting) new SelectionSort(), new BubbleSort(), new CountingSort(), new RadixSort(), new QuickSort());
    }
}
