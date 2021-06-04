package DataStructures.Arrays.ArrayManipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n + 1];
        long max = Long.MIN_VALUE;

        queries.forEach(query -> {
            int firstIdx = query.get(0) - 1;
            int lastIdx = query.get(1);
            int value = query.get(2);

            arr[firstIdx] += value;
            arr[lastIdx] -= value;
        });

        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
        }

        return max;

    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            queries.add(
                    Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList())
            );
        });

        long result = Result.arrayManipulation(n, queries);
        System.out.println(result);
    }
}
