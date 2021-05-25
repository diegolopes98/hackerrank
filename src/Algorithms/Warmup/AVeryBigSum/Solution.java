package Algorithms.Warmup.AVeryBigSum;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Result {

    /*
     * Complete the 'aVeryBigSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY ar as parameter.
     */

    public static long aVeryBigSum(List<Long> ar) {
        return ar.stream().reduce(0L, (acc, curr) -> acc + curr);
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arrCount = in.nextInt();

        List<Long> arr = new LinkedList<>();

        for (int i = 0; i < arrCount; i++) {
            arr.add(in.nextLong());
        }

        long res = Result.aVeryBigSum(arr);

        System.out.println(res);
    }
}