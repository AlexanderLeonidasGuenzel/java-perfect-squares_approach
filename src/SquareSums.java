import java.util.*;
import java.util.stream.IntStream;
import static java.lang.System.*;

public class SquareSums {
    static List<Integer> squares = new ArrayList<>();
    static List<Integer> givenList = new ArrayList<>();

    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    public static List<Integer> buildUpTo(int n) {
        if(n >= 15){
            createList(n);
            createSquares(n);
            out.println("squares: " + squares);
            makeTwoLists();
            out.println(list1 + " " + list2);
            out.println(searchSquares(list1));
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

    public static void makeTwoLists(){

        int start = givenList.get(0);
        int end = givenList.get(givenList.size()-1) + 1;
        int half = givenList.get((givenList.size() / 2) + 1);
        IntStream.range(start, half)
                .forEach(list1::add);
        IntStream.range(half, end)
                .forEach(list2::add);
    }

    public static Map<Integer, List<Integer>> searchSquares(List<Integer> list) {
        Map<Integer, List<Integer>> squarePairs = new HashMap<>();

        for (Integer key : list) {
            for (Integer value : list) {
                int sum = key + value;
                if (!key.equals(value) && squares.contains(sum)) {
                    squarePairs.computeIfAbsent(key, k -> new ArrayList<>()).add(value); //lambda expr. to add a new list for a key
                }
            }
        }
        return squarePairs;
    }
}
