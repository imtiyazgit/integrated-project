package algos.array.facebook.encoding;

public class Solution {

    // String str = "aahhhmnn";
    public static void encoding(char[] A) {
        int counter=1;
        int k=0;
        char prev = A[0];
        for(int i=1;i<A.length;i++) {
            char curr = A[i];
            if(prev == curr) {
                ++counter;
            } else {
                if(counter == 1) {
                    counter=0;
                    continue;
                }
                A[k++] = prev;
                A[k++] = (char) (counter + '0');
                counter=1;
                prev = curr;
            }
        }

        while(k<A.length) {
            A[k++] = ' ';
        }

    }

    public static void main(String[] args) {

        int a = 1;
        char b = (char) a;
        System.out.println(b);


        String str = "aahhhmnn";
        char[] A = str.toCharArray();
        encoding(A);
        System.out.println("Response="+new String(A));
    }
}
