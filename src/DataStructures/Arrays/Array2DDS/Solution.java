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
        List<Integer> sumList = new LinkedList<>();

        for (int i = 1; i < arr.size() - 1; i++) {
            List<Integer> line = arr.get(i);
            for (int j = 1; j < line.size() - 1; j++) {
                Integer sum = line.get(j);
                for (int x = j - 1; x <= j + 1; x++) {
                    sum += arr.get(i - 1).get(x);
                    sum += arr.get(i + 1).get(x);
                }
                sumList.add(sum);
            }
        }

        Integer maxSum = sumList.stream().max(Integer::compare).get();

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
