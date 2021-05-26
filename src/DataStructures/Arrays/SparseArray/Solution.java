package DataStructures.Arrays.SparseArray;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> queriesResult = new LinkedList<>();

        for (int i = 0; i < queries.size(); i++) {
            String query = queries.get(i);
            queriesResult.add(
                    (int) strings.stream()
                            .filter(string -> string.equalsIgnoreCase(query))
                            .count()
            );
        }

        return queriesResult;
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int stringsCount = Integer.parseInt(in.nextLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> in.nextLine())
                .collect(Collectors.toList());

        int queriesCount = Integer.parseInt(in.nextLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> in.nextLine())
                .collect(Collectors.toList());

        List<Integer> res = Result.matchingStrings(strings, queries);

        System.out.println(
                res.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n"))
                        + "\n"
        );
    }
}
