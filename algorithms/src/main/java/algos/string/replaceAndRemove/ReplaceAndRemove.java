package algos.string.replaceAndRemove;

import java.util.Arrays;

/**
 * Created by imtiyaz on 5/14/20.
 */
public class ReplaceAndRemove {


    private static int replaceAndRemove(char[] s, int size) {
        int writeIdx = 0;
        int aCount =0;
        for (int i = 0; i < size; i++) {
            if(s[i] != 'b') {
                // If not b, then add so that we trim off b's
                s[writeIdx++] = s[i];
            }

            if(s[i] == 'a') {
                ++aCount;
            }
        }

        // Trick: By now 'a','c','d', 'c', 'a', 'c', 'a' --> Notice that c is copied onto b and then a is copied onto b and then c and a left out at the end

        // Now first calculate the final length of string. Each a is duplicated. So just add up aCount to get the final size

        // set write index
        int currentIdx = writeIdx -1; // writeIdx was ++ from previous pass. So reset it

        // we want to do writes from backward. So, set writeIdx to last index
        writeIdx = currentIdx + aCount;
        int finalSize = writeIdx + 1; // This field is just to return the size of the array after changes

        while (currentIdx >= 0) {
            if(s[currentIdx] == 'a') {
                s[writeIdx--] = 'd';
                s[writeIdx--] = 'd';
            } else {
                // Tricky part, we are writing all elements again from back side
                s[writeIdx--] = s[currentIdx];
            }
            currentIdx--;
        }

        return finalSize;

    }

    public static void main(String[] args) {
        char[] C = new char[] {'a','c','d', 'b', 'b', 'c', 'a'};
        System.out.println(replaceAndRemove(C, 7));
        System.out.println(Arrays.toString(C)); // d, d, c, d, c, d, d


        char[] C2 = new char[] {'a','c','a', 'a', ' ', ' ', ' '};
        System.out.println(replaceAndRemove(C2, 4)); //[d, d, c, d, d, d, d]
        System.out.println(Arrays.toString(C2));
    }
}
