package algos.array.segregatezerosandones;

public class ZerosToLeftAndOnesToRight {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,0,0,1};

        int[] result = new int[arr.length];

        int endIndex = arr.length -1;
        int startIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                result[startIndex++] = 0;
            } else {
                result[endIndex--] = 1;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
