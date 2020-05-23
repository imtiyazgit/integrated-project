package algos.string.restoreipaddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * ProblemStatement: A developer messed up with the ip address and he lost the . as part of the IP address
 * 25525511135 messed up IP address
 * <p>
 * This is the input for you. And you need to find the possible valid ip addresses containing the . or the parts
 * 2. first part
 * 5. second part
 * 55. second part
 * 555. second part -- not possible.
 * <p>
 * A valid ip address of type IPV4 would have 4 parts and each part can not be greater than 255 and it can 0 as well.
 * But it can not have 00, 01, 02, 000, etc
 * <p>
 * So, the question is, come up with the list of all possible ip address combinations
 * input: 25525511135
 * output: 255.255.111.35 or 255.255.11.135 are the only two possible ip address combinations
 */
public class RestoreIpAddresses {

    // 25525511135
    private static List<String> restoreIPAddress(String s) {
        if (s == null || s.length() == 0) throw new IllegalArgumentException("Invalid input");

        List<String> results = new ArrayList<>();

        // 2
        // 25
        // 255
        // Pay attention to i<4 because we want 0 to 3 index elements
        for (int i = 1; i < s.length() && i < 4; i++) {
            String firstPart = s.substring(0, i);
            if(isValidPart(firstPart)) {
                // Pay attention to j<4 because we want i to j(0) j(1) j(2) thats it.. not more than that.. only 3 for second part too
                // You are accessing i+j element in substring.. so add i+j < s.length too condition
                for (int j = 1; i + j < s.length() && j < 4; j++) {
                    String secondPart = s.substring(i, i+j);
                    if(isValidPart(secondPart)) {
                        for (int k = 1; i + j+ k < s.length() && k < 4; k++) {
                            String thirdPart = s.substring(i+j, i+j+k);
                            String fourthPart = s.substring(i+j+k);
                            if(isValidPart(thirdPart) && isValidPart(fourthPart)) {
                                results.add(firstPart+"."+secondPart+"."+thirdPart+"."+fourthPart);
                            }
                        }
                    }
                }

            }
        }

        return results;
    }

    private static boolean isValidPart(String part) {
        if(part.length() > 3) {
            // A single part at most can be of 3 digits
            return false;
        }
        if(part.startsWith("0") && part.length() > 1) {
            // A part starting with 0 can only exist. You can not have 00, 01, 000, etc
            return false;
        }

        // A valid part can be of range 0 to 255
        Integer value = Integer.parseInt(part);
        return value >0 && value <= 255;
    }

    public static void main(String[] args) {
        System.out.println(restoreIPAddress("25525511135"));
    }
}
