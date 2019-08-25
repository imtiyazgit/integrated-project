package algos.recursion;

public class TowerOfHanoi {

    private static void towerOfHanoi(int n, char fromPeg, char toPeg, char auxPeg) {

        if (n ==1) {
            System.out.printf("Moving disk 1 from fromPeg %f to toPeg %f", fromPeg, toPeg);
            return;
        }

        // Move n-1 pegs from fromPeg to auxPeg
        towerOfHanoi(n-1, fromPeg, auxPeg, toPeg);

        // Move nth peg from fromPeg to toPeg
        towerOfHanoi(n, fromPeg, toPeg, auxPeg);

        // Move n-1 pegs from auxPeg to toPeg
        towerOfHanoi(n-1, auxPeg, toPeg, fromPeg);

    }


    public static void main(String[] args) {

    }
}
