package Algorithms.Warmup.TimeConversion;

import java.util.Scanner;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String[] hourArray;
        int hours, minutes, seconds;
        boolean isPM;

        isPM = s.substring(s.length() - 2).equalsIgnoreCase("PM");

        hourArray = s.substring(0, s.length() - 2).split(":");

        hours = Integer.parseInt(hourArray[0]);
        minutes = Integer.parseInt(hourArray[1]);
        seconds = Integer.parseInt(hourArray[2]);

        if(isPM) {
            hours = hours < 12 ? hours + 12 : hours;
        } else {
            hours = hours >= 12 ? hours - 12 : hours;
        }

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();

        String result = Result.timeConversion(s);

        System.out.println(result);
    }
}
