import java.util.List;

import static java.lang.System.*;

public class Main {
    static List<Integer> countPossible;
    static final int N = 15;

    static int counter = 0;
    public static void main(String[] args) {
        for(int i = 2; i <= 30; i++){
            out.println("perfectsquares for n = " + i + " is: "+ SquareSums.buildUpTo(i));
        }
    }
}
