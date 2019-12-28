package algos.array.missingnumbers;

public class TwoMissingNumbers {

    private static int[] findTwoMissingNumbers(int[] arr) {
        // First calculate the sum of two missing numbers using n(n+1)/2 - arr.sum

        int idealLength = arr.length + 2;
        int idealSum = idealLength * (idealLength+1) / 2;

        // You can directly use array elements to calculate its sum
        int arrSum = 0;
        for (int i: arr) {
            arrSum += i;
        }

        int sumOfMissingNumbers  = idealSum - arrSum;

        //System.out.println(sumOfMissingNumbers);

        // To find individual numbers, what we need to do is divide the arr to half and do xor in each half to find out

        int idealXorForLeftHalf = 0;
        int arrXorForLeftHalf =0;
        int idealXorForRightHalf = 0;
        int arrXorForRightHalf = 0;

        int middle = sumOfMissingNumbers/2;

        // Now ideal xor for left half and right half
        for (int i=1; i<=middle; i++) {
            idealXorForLeftHalf = idealXorForLeftHalf ^ i;
        }

        for (int i=middle+1; i<= idealLength; i++) {
            idealXorForRightHalf = idealXorForRightHalf ^ i;
        }

        // Now get xor for given array for left half and right half
        for (int i:arr) {
            if (i<=middle) {
                arrXorForLeftHalf = arrXorForLeftHalf ^ i;
            } else {
                arrXorForRightHalf = arrXorForRightHalf ^ i;
            }
        }

        // Now perform xor with idealLeftxor ^ arrLeftXor and like wise for right xor

        return new int[] { idealXorForLeftHalf ^ arrXorForLeftHalf,
                            idealXorForRightHalf ^ arrXorForRightHalf};

    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        for (int i:findTwoMissingNumbers(arr)) {
            System.out.println(i);
        }
    }
}
