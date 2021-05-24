package DataStructures.Arrays.ArraysDS;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Integer> reverseArray(List<Integer> a) {
        List<Integer> reverseList = new LinkedList<>();

        for (int i = a.size() - 1; i >= 0; i--) {
            reverseList.add(a.get(i));
        }

        return reverseList;
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

        List<Integer> res = Result.reverseArray(arr);

        System.out.println(
                res.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
        );
    }
}