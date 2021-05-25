package Algorithms.Warmup.DiagonalDifference;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum1 = 0, sum2 = 0;
        int pos1 = 0, pos2 = arr.size() - 1;

        for(int i = 0; i < arr.size(); i++) {
            for(int j = arr.get(i).size() -1 ; j >=0 ; j--) {
                if(j == pos1) sum1 += arr.get(i).get(j);
                if(j == pos2) sum2 += arr.get(i).get(j);
            }
            pos1 += 1;
            pos2 -= 1;
        }

        return Math.abs(sum1 - sum2);
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            arr.add(
                    Stream.of(in.next().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList())
            );
        });

        int result = Result.diagonalDifference(arr);

        System.out.println(result);
    }
}