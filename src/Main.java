import java.util.ArrayList;
import java.util.List;
import static java.lang.System.*;

public class Main {
     static final int N = 15;
    static List<Integer> givenList = new ArrayList<>();
    public static void main(String[] args) {

        createList();
        out.println(givenList);
        out.println(SquareSums.buildUpTo(N));
    }

    public static void createList(){

        for(int i = 1; i <= N; i++){
            givenList.add(i);
        }
    }
}