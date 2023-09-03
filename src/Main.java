import java.util.Arrays;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 15;
        int[] givenNumbers = new int[SIZE];

        //fill array with numbers from 1 to 15
        for (int i = 0; i < SIZE; i++) {
            givenNumbers[i] = i + 1;
        }
        out.println("Given numbers: " + Arrays.toString(givenNumbers));
    }
}