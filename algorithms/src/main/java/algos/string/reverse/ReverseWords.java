package algos.string.reverse;

public class ReverseWords {

    private static void reverseWords(char[] input) {
        int n = input.length;

        // Reverse complete string
        reverse(input, 0, n - 1);

        // Now reverse each word
        int start = 0, finish = 0;

        while(start < n) {

            // After reversing each word, bring start to equal finish
            while (start < finish) {
                ++start;
            }

            // Start must ignore spaces
            while(start<n && input[start] == ' ') {
                ++start;
            }

            // Since start index goes ahead than finish, because, it skips spaces, finish can be less.bring it equal
            while(finish<start) {
                ++finish;
            }

            // Until you find space, increase finish. Have finish<n first operator because, you dont want to search the index beyond the size
            while(finish<n && input[finish] != ' ') {
                ++finish;
            }

            reverse(input, start, finish-1);
        }

    }

    private static void reverse(char[] input, int startIndex, int endIndex) {
        while(startIndex<endIndex) {
            char temp = input[startIndex];
            input[startIndex] = input[endIndex];
            input[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        String str = "ram is costly";
        char[] input = str.toCharArray();
        reverseWords(input);
        System.out.println(input);
    }
}
