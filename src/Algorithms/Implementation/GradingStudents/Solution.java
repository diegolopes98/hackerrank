package Algorithms.Implementation.GradingStudents;


import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades
                .stream()
                .map(grade -> {
                    int nextRoundValue = ((grade + 4) / 5) * 5;
                    if (nextRoundValue >= 40 && nextRoundValue - grade < 3) return nextRoundValue;
                    return grade;
                })
                .collect(Collectors.toList());
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int gradesCount = Integer.parseInt(in.nextLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> in.nextLine().replaceAll("\\s+$", ""))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = Result.gradingStudents(grades);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n"))
                        + "\n"
        );
    }
}
