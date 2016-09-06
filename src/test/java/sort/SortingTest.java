package sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SortingTest {

    public Sorting sorting;

    public SortingTest(Sorting sorting) {
        this.sorting = sorting;
    }

    @Test
    public void case01() {
        int[] testArray = {4, 12, 32, 1, 8, 2, 20};
        int[] expectedArray = {1, 2, 4, 8, 12, 20, 32};
        simpleSelectionMin(testArray, expectedArray);
    }

    @Test
    public void case02() {
        int[] testArray = {4, -1, 32, 1, 8, -20, 20};
        int[] expectedArray = {-20, -1, 1, 4, 8, 20, 32};
        simpleSelectionMin(testArray, expectedArray);
    }

    @Test
    public void case03() {
        int[] testArray = {4, -1, 32, 1, 8, -20, 1, 20};
        int[] expectedArray = {-20, -1, 1, 1, 4, 8, 20, 32};
        simpleSelectionMin(testArray, expectedArray);
    }

    void simpleSelectionMin(int[] testArray, int[] expectedArray) {
        int[] resultArray = sorting.sort(testArray);
        Assert.assertArrayEquals(expectedArray, resultArray);
        System.out.println("in: " + Arrays.toString(testArray));
        System.out.println("out: " + Arrays.toString(expectedArray));
        System.out.println("everything is ok");
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Sorting> instancesToTest() {
        return Arrays.asList(new Selection(), new Bubble());
    }
}
