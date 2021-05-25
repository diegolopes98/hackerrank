package Algorithms.Warmup.CompareTheTriplets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new LinkedList<>(Arrays.asList(0, 0));

        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if(a.get(i) > b.get(i)) {
                result.set(0, result.get(0) + 1);
            } else if (a.get(i) < b.get(i)) {
                result.set(1, result.get(1) + 1);
            }
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> arr1 = new LinkedList<>();
        List<Integer> arr2 = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            arr1.add(in.nextInt());
        }

        for (int i = 0; i < 3; i++) {
            arr2.add(in.nextInt());
        }

        List<Integer> result = Result.compareTriplets(arr1, arr2);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
                        + "\n"
        );
    }
}
