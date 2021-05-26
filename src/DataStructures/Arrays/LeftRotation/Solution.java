package DataStructures.Arrays.LeftRotation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        for(int i = 0; i < d; i++) {
            Integer value = arr.remove(0);
            arr.add(value);
        }
        return arr;
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = Result.rotateLeft(d, arr);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
                        + "\n"
        );
    }
}
