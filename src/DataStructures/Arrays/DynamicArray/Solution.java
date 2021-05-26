package DataStructures.Arrays.DynamicArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        ArrayList<ArrayList<Integer>> arrs = new ArrayList<>();
        LinkedList<Integer> lastAnswerList = new LinkedList<>();
        Integer lastAnswer = 0;

        for (int i = 0; i < n; i++) {
            arrs.add(new ArrayList<>());
        }

        for (int i = 0; i < queries.size(); i++) {
            List<Integer> query = queries.get(i);
            Integer q = query.get(0);
            Integer x = query.get(1);
            Integer y = query.get(2);

            ArrayList<Integer> seq = arrs.get((x ^ lastAnswer) % n);

            if(q == 1) {
                seq.add(y);
            } else if (q == 2){
                lastAnswer = seq.get(y % seq.size());
                lastAnswerList.add(lastAnswer);
            }
        }

        return lastAnswerList;
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            queries.add(
                    Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList())
            );
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n"))
                        + "\n"
        );
    }
}