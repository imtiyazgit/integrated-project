package algos.array2d.numberofislands;

public class NumberOfIslands {
    //grid = [
    //  ["1","1","1","1","0"],
    //  ["1","1","0","1","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","0","0","0"]
    // output: 1

    // Input: grid = [
    //  ["1","1","0","0","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","1","0","0"],
    //  ["0","0","0","1","1"]
    //] output: 3
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    numIslands += markCurrentIsland(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    public static int markCurrentIsland(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0';
        markCurrentIsland(grid, i+1, j);
        markCurrentIsland(grid, i-1, j);
        markCurrentIsland(grid, i, j+1);
        markCurrentIsland(grid, i, j-1);
        return 1;
    }

    public static void main(String[] args) {
        char[][] input = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };

        System.out.println(numIslands(input));
    }
}
