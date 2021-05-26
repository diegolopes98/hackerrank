package Algorithms.Warmup.PlusMinus;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        long positive = 0L;
        long negative = 0L;
        long zero = 0L;

        positive = arr.stream().filter(number -> number > 0).count();
        negative = arr.stream().filter(number -> number < 0).count();
        zero = arr.stream().filter(number -> number == 0).count();

        System.out.println((double) positive/arr.size());
        System.out.println((double) negative/arr.size());
        System.out.println((double) zero/arr.size());
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> arr = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Result.plusMinus(arr);
    }
}