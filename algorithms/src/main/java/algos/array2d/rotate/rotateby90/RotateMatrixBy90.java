package algos.array2d.rotate.rotateby90;

/**
 * Problem: Rotate matrix by 90 clockwise
 */
public class RotateMatrixBy90 {


    // Think about a result and how to set the first row onto the result's last column
    // When you iterate two loops of 2d array, you will get firt row
    // So, now we know that the row should become column, set j as row in the result i.e. result[j]
    // For column field, you know that it has be original arrays row length
    private static int[][] rotateBy90UsingExtraMemory(int[][] arr) {
        int[][] result = new int[arr.length] [arr[0].length];

        // In the result, the first row of original matrix becomes last column in result

        int totalColumnEnd = arr.length-1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // Row iteration.. Each row becomes column. You need to have totalColumnEnd
                // We have already set totalColumnEnd from rows of input array
                result[j][totalColumnEnd-i]= arr[i][j];
            }
        }

        return result;
    }


    /**
     * Rotate matrix in place with O(1) space
     *
     */
    private static int[][] rotateBy90InPlace(int[][] A) {
        int N = A.length;

        // Step 1 : Transpose Matrix meaning convert columns to rows
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }

        // Step2: Now flip horizontally: This means, go row by row, and swap elements inwards. The first element of row1 and last element of row1 will be swapped. The second element of row1 and secondtolast element of row1 willl be swapped.. Likewise inward until you reach middle
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < N/2; j++) {
                //int elem1OfRowFromBeg = A[i][j];
                //int elem2OfRowFromLast = A[i][N-1-j];

                // Swap A[i][j] with A[i][N-1-j]  ^******^ those carots is what we are swapping
                int temp = A[i][j];
                A[i][j] = A[i][N-1-j];
                A[i][N-1-j] = temp;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[][] arr =  new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int[][] result = rotateBy90UsingExtraMemory(arr);
        printMatrix(result);

        System.out.println("-----------");
        int[][] result2 = rotateBy90InPlace(arr);

        printMatrix(result2);
    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
