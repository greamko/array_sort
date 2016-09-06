package sort;

public class Bubble implements Sorting {
    public int[] sort(int[] array) {
        int[] resultArray = array.clone();
        boolean isMoved = true;
        int temp;
        while (isMoved) {
            isMoved = false;
            for (int i = 1; i < resultArray.length; i++) {
                if (resultArray[i - 1] > resultArray[i]) {
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
