import java.util.*;
import java.util.stream.IntStream;
import static java.lang.System.*;

public class SquareSums {
    static List<Integer> squares = new ArrayList<>();
    static List<Integer> givenList = new ArrayList<>();

    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    static List<Integer> perfectSquares = new ArrayList<>();

    public static List<Integer> buildUpTo(int n) {
        if(n >= 15){
            createList(n);
            out.println("givenList " + givenList);
            createSquares(n);
            out.println("squares: " + squares);
            makeTwoLists();
            out.println("List 1 " + list1 + " Liste 2 " + list2);
            Map<Integer, List<Integer>> m = searchSquares(givenList);
            out.println("permutations " + m);
            out.println("MapSize " + m.size());
            int key = 5;
            out.println("< " + key  + " | " + m.get(key) + " >");
            out.println("Size of Value " + m.get(key).size());
            return perfectSquares;
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

    public static int calSumOfN(int n){
        return (n*n+n)/2;
    }

    public static double divideSumByN(int n){
        return calSumOfN(n) / (double) n;
    }
}
