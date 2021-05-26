package Algorithms.Warmup.BirthdayCakeCandles;


import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        int higher = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0; i < candles.size(); i++) {
            int curr = candles.get(i);

            if(higher == curr) count += 1;
            else if(higher < curr) {
                higher = curr;
                count = 1;
            }
        }

        return count;
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int candlesCount = in.nextInt();

        List<Integer> candles = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = Result.birthdayCakeCandles(candles);

        System.out.println(String.valueOf(result));
    }
}
