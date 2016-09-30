import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sort.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);

        List<Sorting> sortingList = new ArrayList<>(Arrays.asList(
                new BubbleSort(),
                new HeapSort(),
                new MergeSort(),
                new QuickSort(),
                new SelectionSort()
        )
        );
        List<Sorting> positiveSortingList = new ArrayList<>(sortingList);
        positiveSortingList.addAll(Arrays.asList(new RadixSort(), new CountingSort()));

        int count = 1;
        while (count <= 100000) {
            /*non negative*/
            System.out.println("---------------------------------------------");
            System.out.println("Count:" + count + "; min: 0; max: 1000000;");
            int[] array = ArrayGenerator.generateArray(count, 0, 1000000);
            sort(positiveSortingList, array);

            System.out.println("Count:" + count + "; min: -1000000; max: 0;");
            array = ArrayGenerator.generateArray(count, -1000000, 0);
            sort(sortingList, array);

            System.out.println("Count:" + count + "; min: -1000000; max:1000000;");
            array = ArrayGenerator.generateArray(count, -1000000, 1000000);
            sort(sortingList, array);

            System.out.println("---------------------------------------------");
            System.out.println("Sorted ASK");
            System.out.println("Count:" + count + "; min: 0; max: 1000000;");
            array = ArrayGenerator.generateArray(count, 0, 1000000);
            Arrays.sort(array);
            sort(positiveSortingList, array);
            //reverse array
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }

            System.out.println("Sorted DESC");
            System.out.println("Count:" + count + "; min: 0; max: 1000000;");
            sort(positiveSortingList, array);

            count *= 10;
        }
    }

    private static void sort(List<Sorting> sorters, int[] array) {
        for (Sorting sorter : sorters) {
            int[] sortingArray = array.clone();
            System.out.println("sort: " + sorter.getClass().getName());
            long startTime = System.nanoTime();

            sorter.sort(sortingArray);

            long endTime = System.nanoTime();

            System.out.println("That took " + (double) (endTime - startTime) / 1000000 + " milliseconds\r\n");
        }
    }
}
