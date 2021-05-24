package Algorithms.Warmup.Staircase;

import java.util.Scanner;

class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        String staircase = "";
        for (int line = 1; line < n + 1; line++) {
            for (int column = n; column > 0; column--) {
                if (column > line) staircase += " ";
                else staircase += "#";
            }
            staircase += "\n";
        }
        System.out.println(staircase);
    }

}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        Result.staircase(size);
    }
}
