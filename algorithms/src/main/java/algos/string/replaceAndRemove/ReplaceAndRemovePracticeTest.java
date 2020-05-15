package algos.string.replaceAndRemove;

import java.util.Arrays;

public class ReplaceAndRemovePracticeTest {


    private static Object getReplaceAndRemove(char[] s, int size) {
        // First remove bs forward iteration
        int writeIdx=0;
        int aCount = 0;
        for (int i = 0; i < size; i++) {
            if(s[i] != 'b') {
                s[writeIdx++] = s[i];
            } else {
                aCount++;
            }

        }

        // writeIdx went ahead. So now have currentIdx pointed to it and use writeIdx for backward iteration
        int currentIdx = writeIdx -1;
        writeIdx = currentIdx + aCount;
        int finalSize = writeIdx + 1;

        while(currentIdx >= 0) {
            if(s[currentIdx] == 'a') {
                s[writeIdx--] = 'd';
                s[writeIdx--] = 'd';
            } else {
                s[writeIdx--] = s[currentIdx];
            }
            currentIdx--;
        }
        return finalSize;
    }


    public static void main(String[] args) {
        char[] C = new char[] {'a','c','d', 'b', 'b', 'c', 'a'};
        System.out.println(getReplaceAndRemove(C, 7));
        System.out.println(Arrays.toString(C)); // d, d, c, d, c, d, d
    }


}
