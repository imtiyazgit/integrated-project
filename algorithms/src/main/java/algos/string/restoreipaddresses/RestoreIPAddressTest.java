package algos.string.restoreipaddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddressTest {

    /**
     * 25525511125
     * List {255.255.111.25
     * 255.255.11.125}
     */
    private static List<String> restoreIPAddress(String s) {
        if (s == null || s.length() == 0) throw new IllegalArgumentException("Invalid input");
        List<String> results = new ArrayList<>();

        for (int i = 1; i < 4; i++) { // i denotes first part substring
            String firstPart = s.substring(0, i); // 0 to i exclusive
            if(isValidPart(firstPart)) {
                for (int j = 1; j < 4; j++) { // j denotes second part substring
                    String secondPart = s.substring(i, i+j);
                    if(isValidPart(secondPart)) {
                        for (int k = 1; k < 4 ; k++) {
                            String thirdPart = s.substring(i+j, i+j+k);
                            String fourthPart = s.substring(i+j+k);
                            if(isValidPart(thirdPart) && isValidPart(fourthPart)) {
                                results.add(firstPart +"." +secondPart +"."+thirdPart +"."+fourthPart);
                            }
                        }
                    }
                }
            }

        }

        return results;
    }

    // 255.255.11.251
    private static boolean isValidPart(String s) {
        if(s.length() > 3) {
            return false;
        }

        if(s.startsWith("0") && s.length() > 1) {
            // Only 0 is allowed. But multiple 0s or any thing that starts with 0 is invalid
            return false;
        }

        int value = Integer.parseInt(s);

        return value <= 255 && value >= 0;
    }

    public static void main(String[] args) {
        System.out.println(restoreIPAddress("25525511125"));
    }

}
