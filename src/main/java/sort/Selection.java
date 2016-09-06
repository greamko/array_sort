package sort;

public class Selection implements Sorting {
    public int[] sort(int[] array) {
        int[] resultArray = array.clone();
        int minIndex = 0;
        int temp = 0;
        int counter = 0;

        for (; counter < resultArray.length; counter++) {
            minIndex = counter;
            for (int i = counter; i < resultArray.length; i++) {
                if (resultArray[minIndex] > resultArray[i]) {
                    minIndex = i;
                }
            }
            if (minIndex != counter) {
                temp = resultArray[minIndex];
                resultArray[minIndex] = resultArray[counter];
                resultArray[counter] = temp;
            }
        }

        return resultArray;
    }
}
