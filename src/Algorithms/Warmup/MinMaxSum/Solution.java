package Algorithms.Warmup.MinMaxSum;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long sum = 0L;

        for(int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            min = Math.min(min, arr.get(i));
            max = Math.max(max, arr.get(i));
        }

        System.out.print(String.format("%d %d", (sum - max), (sum - min)));
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> arr = Stream.of(in.next().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Result.miniMaxSum(arr);
    }
}