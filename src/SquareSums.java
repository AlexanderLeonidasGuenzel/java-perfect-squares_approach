import java.util.*;
import java.util.stream.IntStream;

public class SquareSums {

    static List<Integer> squares = new ArrayList<>();

    public static List<Integer> buildUpTo(int n) {
        if(n > 5){
            createSquares(n);
            return squares;
        }
        return null;
    }

    public static void createSquares(int n){
        try{
            IntStream.range(2, (int) Math.sqrt(2 * n - 1.0) + 1)
                    .map(i -> i * i)
                    .forEach(squares::add);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Ungültige Eingabe: n ist zu klein.");
        }

    }


}