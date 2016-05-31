package algos.array;

public class UnionOfSortedArrays {

    static void union(int[] arr1, int[] arr2) {
        int i=0;
        int j=0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                System.out.println(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                System.out.println(arr2[j]);
                j++;
            } else {
                System.out.println(arr1[i]);
                i++; j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] i1 = {1,2,3,5,8,9};
        int[] i2 = {2,5,7,9};

        union(i1, i2);
    }
}
