package Algorithms.Implementation.NumberLineJumps;


import java.util.Scanner;

class Result {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    enum ANSWER {
        NO,
        YES
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        long xDiff = Math.abs(x1 - x2);
        long vDiff = Math.abs(v1 - v2);

        if (
                (
                        (x1 > x2 && v1 < v2) || (x1 < x2 && v1 > v2)
                ) && (xDiff % vDiff == 0)
        ) return ANSWER.YES.name();

        return ANSWER.NO.name();
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] firstMultipleInput = in.next().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result.kangaroo(x1, v1, x2, v2);

        System.out.println(result);
    }
}
