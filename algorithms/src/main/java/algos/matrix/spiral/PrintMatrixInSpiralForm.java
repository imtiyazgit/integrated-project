package algos.matrix.spiral;

public class PrintMatrixInSpiralForm {



    private static void printUsingIterative(int[][] matrix, int rowStart, int colStart, int rowLength, int colLength) {

        while (rowStart < rowLength && colStart < colLength) {

            // Print right
            for (int i = 0; i < colLength; i++) {
                System.out.println(matrix[rowStart][i]);
            }

            // Print down
            for (int k = rowStart+1; k < rowLength; k++) {
                System.out.println(matrix[k][colLength-1]);
            }

            // Print left
            for (int l = colLength -1; l > colStart; l--) {
                System.out.println(matrix[l][rowLength-1]);
            }

            // Print Up
           /* for (int m = rowLength; m < rowStart +1; m--) {
                System.out.println(matrix[m][rowStart]);
            }*/

            rowStart++;
            rowLength--;
            colStart++;
            colLength--;


        }



    }


    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        printUsingIterative(matrix, 0, 0, matrix.length, matrix[0].length);
    }
}
