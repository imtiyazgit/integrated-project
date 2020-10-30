package algos.array.facebook.encoding;

public class Sol2 {
    public static void encoding(char[] A) {
        int count=1;
        int k=0;
        for (int i = 1; i <= A.length; i++) {
            if(i == A.length || A[i] != A[i-1]) {
                if(count != 1) {
                    A[k++] = (char) (count+'0');
                }
                A[k++] = A[i-1];
                count=1;
            } else {
                ++count;
            }
        }

        while(k<A.length) {
            A[k++] = ' ';
        }

    }

    public static void main(String[] args) {
        char[] A = "aabbbcdddda".toCharArray();
        encoding(A);
        System.out.println(new String(A));
    }
}
