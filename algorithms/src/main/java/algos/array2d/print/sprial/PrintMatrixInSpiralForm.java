package algos.array2d.print.sprial;

/** TC: O(n2)
 * SC: O(1)
 */
public class PrintMatrixInSpiralForm {

    // Idea: Use 4 for loops
    // First loop : go from left to right . for this you need colBegin to colEnd variables. Then rowBegin++ because you already printed
    // Second loop: go from rowBegin to rowEnd. Now you printed last column completely. So, do colEnd--
    // Third loop: go from colEnd to colBegin. Now you printed last row completely. so, do rowEnd--
    // Fourth loop: go from rowEnd to rowBegin. Now you printed first column completely. So, do colBegin--

    private static void printMatrixSpiral(int[][] A) {
        if(A == null || A.length ==0) {
            throw new IllegalArgumentException("Input is either null or empty");
        }

        // Now create all the variables to go from left to right, down, left and up
        int rowStart=0;
        int rowEnd = A.length-1;
        int colStart =0;
        int colEnd = A[0].length-1;

        while(rowStart <= rowEnd && colStart <= colEnd) {

            // First loop : go from left to right . for this you need colBegin to colEnd variables. Then rowBegin++ because you already printed
            for (int i = colStart; i <= colEnd ; i++) {
                System.out.println(A[rowStart][i]);
            }

            // Now that row is printed, increment it, so that we dont repeat it again
            rowStart++;

            // Second loop: go from rowBegin to rowEnd. Now you printed last column completely. So, do colEnd--
            for (int i = rowStart; i <= rowEnd; i++) {
                System.out.println(A[i][colEnd]); // printing column, set that index same
            }

            // Now that end column is printed, decrement it, so that we dont repeat it again
            colEnd--;

            // Third loop: go from colEnd to colBegin. Now you printed last row completely. so, do rowEnd--
            for (int i = colEnd; i >= colStart; i--) {
                System.out.println(A[rowEnd][i]); // printing row, so, rowEnd and i should be used
            }

            // Now that end row is printed, decrement it
            rowEnd--;

            // Fourth loop: go from rowEnd to rowBegin. Now you printed first column completely. So, do colBegin--
            for (int i = rowEnd; i >= rowStart ; i--) {
                System.out.println(A[i][colStart]); // printing column, colStart should be used. Iterating i, so should be rowIndex
            }

            // Now that colStart printed, increment it
            colStart++;
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        int[][] matrix2 = new int[][] {
                {1, 2, 3, 4},
                {6, 7, 8, 9},
                {11, 12, 13, 14},
                {16, 17, 18, 19}
        };

        printMatrixSpiral(matrix);

        System.out.println("-----------");

        printMatrixSpiral(matrix2);

    }
}
