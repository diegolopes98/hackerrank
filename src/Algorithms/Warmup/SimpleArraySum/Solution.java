package Algorithms.Warmup.SimpleArraySum;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'simpleArraySum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ar as parameter.
     */

    public static int simpleArraySum(List<Integer> arr) {
        return arr.stream().reduce(0, (amount, current) -> amount + current);
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arrCount = in.nextInt();

        List<Integer> arr = new LinkedList<>();

        for (int i = 0; i < arrCount; i++) {
            arr.add(in.nextInt());
        }

        Integer res = Result.simpleArraySum(arr);

        System.out.println(res);
    }
}
