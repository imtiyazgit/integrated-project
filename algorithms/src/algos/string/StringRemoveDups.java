package algos.string;

/**
 * Created by imtiyaz on 6/12/16.
 */
public class StringRemoveDups {

    static void removeDups(char[] arr) {

        if (arr == null) {
            return;
        }

        int length = arr.length;
        if (length < 2) {
            return;
        }

        int tail = 1;
        for (int i=1; i<length;++i) {
            int j;
            for (j=0; j<tail;++j) {
                if (arr[i] == arr[j]) {
                    break;
                }
            }

            if (j==tail) {
                arr[tail] = arr[i];
                ++tail;
            }
        }

        for (int i=tail;i<length;i++) {
            arr[i] = 0;
        }

        System.out.println(arr);
    }

    public static void main(String[] args) {
        String str = "abababa";
        removeDups(str.toCharArray());
    }
}
