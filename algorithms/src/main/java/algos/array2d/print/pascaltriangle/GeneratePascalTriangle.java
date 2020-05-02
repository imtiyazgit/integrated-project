package algos.array2d.print.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

/**
 *        1
 *      1  1
 *    1  2  1
 *  1 3  3   1
 * 1 4  6  4  1
 *
 * Technique: Note that, you can generate easily if you use previous rows'0 the element + first element sum
 * So, first add the row-1 with list{1}
 * Now, forI to requestedInput, create a new row.
 * In the new row, add 1 first
 * next, iterate a loop to populate new row. use previous rows j-1 and j elements to sum up
 * Now, you populated, add 1 again to the new row
 * thats, it. If you miss adding 1 again to the new row, you will have issues. dont forget this
 *
 *
 */
public class GeneratePascalTriangle {

    private static List<List<Integer>> generatePascalTriangle(int num) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        if(num==0) {
            // Either throw exception or return empty list
            throw new IllegalArgumentException("Invalid input!");
        }

        // Add first row with 1
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        pascalTriangle.add(firstRow);

        // Now since you already added row1, start iteration from 1 to <num to generate that many rows
        for (int i = 1; i < num ; i++) {

            // Now for each i, you need to generate row from previous row
            List<Integer> newRow = new ArrayList<>();

            // At the beginning of new row, add 1
            newRow.add(1); // All rows would have 1 in it to begin with

            // To populate elements into this new row, start iteration from 1, as 0th index with value 1 is already populated
            // Max elements is the row number. for example if you are adding row2, j<2
            List<Integer> previousRow = pascalTriangle.get(i-1);
            for (int j = 1; j < i; j++) {
                newRow.add(previousRow.get(j-1) + previousRow.get(j)); // Always add 0th and first element of previous row. thats it. In iteration, it will take care
            }

            // At the end, we need to add 1 too
            newRow.add(1);

            pascalTriangle.add(newRow);
        }

        return pascalTriangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> pascalTriangle = generatePascalTriangle(5);

        System.out.println(pascalTriangle);
    }
}
