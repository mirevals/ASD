package lab1app.tasks;

public class BinaryArrayProcessor {
    public boolean[] isDivisibleByN(int[] biArr, int n) {
        int decimal = 0;
        boolean[] result = new boolean[biArr.length];
        for (int i = 0; i < biArr.length; i++) {
            decimal = (decimal << 1) | biArr[i];
            result[i] = decimal % n == 0;
        }
        return result;
    }
}