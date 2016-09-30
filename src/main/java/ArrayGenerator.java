import java.util.Random;

public class ArrayGenerator {

    public static int[] generateArray(int size, int min, int max) {
        int[] resultArr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            resultArr[i] = random.nextInt(max - min) + min;
        }
        return resultArr;
    }
}
