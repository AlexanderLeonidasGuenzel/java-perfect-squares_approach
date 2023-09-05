import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SquareSums {
    static List<Integer> squares = new ArrayList<>();
    static List<Integer> givenList = new ArrayList<>();

    public static List<Integer> buildUpTo(int n) {
        if(n >= 15){
            createList(n);
            createSquares(n);
            System.out.println(makeTwoLists());
            return givenList;
        }
        return null;
    }
    public static void createList(int n){
        IntStream.range(1, n + 1)
                .forEach(givenList::add);
    }
    public static void createSquares(int n){
        try{
            IntStream
                    .range(2, (int) Math.sqrt(2 * n - 1.0) + 1)
                    .map(i -> i * i)
                    .forEach(squares::add);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Invalid input: n is too small.");
        }
    }

    public static List<List<Integer>> makeTwoLists(){

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int end = givenList.size() + 1;
        int half = end - (givenList.size() / 2);
        IntStream.range(0, half)
                .forEach(list1::add);
        IntStream.range(half, end)
                .forEach(list2::add);

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        return list;
    }
}
