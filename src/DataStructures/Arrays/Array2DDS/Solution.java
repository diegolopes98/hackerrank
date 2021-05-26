package DataStructures.Arrays.Array2DDS;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        Integer maxSum = Integer.MIN_VALUE;

        for (int i = 1; i < arr.size() - 1; i++) {
            for (int j = 1; j < arr.get(i).size() - 1; j++) {
                Integer sum = 0;

                sum += arr.get(i - 1).get(j - 1); // top lef
                sum += arr.get(i - 1).get(j); // top middle
                sum += arr.get(i - 1).get(j + 1); // top right
                sum += arr.get(i).get(j); // current
                sum += arr.get(i + 1).get(j - 1); // bottom lef
                sum += arr.get(i + 1).get(j); // bottom middle
                sum += arr.get(i + 1).get(j + 1); // bottom right

                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            List<Integer> line = Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            arr.add(line);
        }

        int result = Result.hourglassSum(arr);

        System.out.println(result);
    }
}
