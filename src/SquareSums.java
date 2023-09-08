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

                if(allHasSquarePair(squarePairs, givenList)){
                    return perfectSquares;
                }
                else {
                    return null;
                }
            }

        }
        return null;
    }
    public static List<Integer> createList(int n){

        List<Integer> list = new ArrayList<>();

        IntStream.range(1, n + 1)
                .forEach(list::add);
        return list;
    }
    public static List<Integer> createSquares(int n){

        List<Integer> list = new ArrayList<>();

        try{
            IntStream
                    .range(2, (int) Math.sqrt(2 * n - 1.0) + 1)
                    .map(i -> i * i)
                    .forEach(list::add);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Invalid input: n is too small.");
        }
        return list;
    }

    public static Map<Integer, List<Integer>> searchSquares(List<Integer> givenList, List<Integer> squares) {

        Map<Integer, List<Integer>> unsortedMap = new HashMap<>();

        for (Integer key : givenList) {
            for (Integer value : givenList) {
                int sum = key + value;
                if (!key.equals(value) && squares.contains(sum)) {
                    unsortedMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
                }
            }if(unsortedMap.get(key) == null){
                return null;
            }
        }
        List<Map.Entry<Integer, List<Integer>>> entries = new ArrayList<>(unsortedMap.entrySet());

        entries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        Map<Integer, List<Integer>> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static Map<Integer, Integer> countKeysByListSize(Map<Integer, List<Integer>> map) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (List<Integer> valueList : map.values()) {
            int size = valueList.size();
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }
        return countMap;
    }

    public static boolean allHasSquarePair(Map<Integer, List<Integer>> map, List<Integer> list) {
        for (Integer entry : list) {
            if (!map.containsKey(entry)) {
                return false;
            }
        }
        return true;
    }
}
