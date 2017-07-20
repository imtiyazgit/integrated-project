package algos.array;

public class IntersectionOfThreeSortedArrays {
    static void intersect(int[] arr1, int[] arr2, int[] arr3) {
        int i=0, j=0, k=0;

        while (i<arr1.length && j<arr2.length && k<arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                System.out.println(arr1[i]);
                i++;j++;k++;
            }
            else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] i1 = {1,2,3,5,8,9};
        int[] i2 = {2,5,7,9};
        int[] i3 = {2,9,10};

        intersect(i1, i2, i3);
    }
}
