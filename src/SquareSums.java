import java.util.*;
import java.util.stream.IntStream;
import static java.lang.System.*;

public class SquareSums {
    static List<Integer> givenList = new ArrayList<>();
    static List<Integer> squares = new ArrayList<>();
    static List<Integer> perfectSquares = new ArrayList<>();

    static Map<Integer, List<Integer>> squarePairs;

    static Map<Integer, Integer> countMap = new HashMap<>();

    public static List<Integer> buildUpTo(int n) {
        if(n >= 1){
            givenList = createList(n);
            squares = createSquares(n);
            squarePairs =  searchSquares(givenList,squares);
            if(squarePairs  != null ){
                out.println("SquarePairs " + squarePairs);
                countMap = countKeysByListSize(squarePairs);
                out.println("CountKeysByListSize " + countMap);
            }
        }
        return null;
    }

    public static List<Integer> createList(int n) {
        return IntStream.range(1, n + 1)
                .boxed()
                .toList();
    }

    public static List<Integer> createSquares(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("Invalid input: n is too small.");
        }

        return IntStream
                .range(2, (int) Math.sqrt(2 * n - 1.0) + 1)
                .map(i -> i * i)
                .boxed()
                .toList();
    }

    public static Map<Integer, List<Integer>> searchSquares(List<Integer> givenList, List<Integer> squares) {
        Map<Integer, List<Integer>> resultMap = new HashMap<>();

        for (Integer key : givenList) {
            boolean keyHasEntry = false;
            for (Integer value : givenList) {
                if (!key.equals(value)) {
                    int sum = key + value;
                    if (squares.contains(sum)) {
                        resultMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
                        keyHasEntry = true;
                    }
                }
            }
            if (!keyHasEntry) {
                return null;
            }
        }
        return resultMap;
    }

    public static Map<Integer, Integer> countKeysByListSize(Map<Integer, List<Integer>> map) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (List<Integer> valueList : map.values()) {
            int size = valueList.size();
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }
        return countMap;
    }
}
