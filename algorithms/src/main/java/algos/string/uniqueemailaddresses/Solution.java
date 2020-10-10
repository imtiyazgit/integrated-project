package algos.string.uniqueemailaddresses;
import java.util.*;

public class Solution {
    // I/p: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
    // o/p: 2 "testemail@leetcode.com" and "testemail@lee.tcode.com"
    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0) {
            return 0;
        }

        // map of email->emailcount
        Map<String, Integer> domainEmailCountMap = new HashMap<>();

        for(String email:emails) {
            String domain = email.split("@")[1];
            String s = email.split("@")[0];
            s = trimCharsPostPlus(s);
            s = removeDots(s);

            domainEmailCountMap.put(s+"@"+domain, domainEmailCountMap.getOrDefault(s+"@"+domain, 0)+1);

        }

        return domainEmailCountMap.size();
    }

    private String removeDots(String s) {
        while(s.indexOf(".")>=0) {
            s = s.substring(0, s.indexOf(".")) + s.substring(s.indexOf(".")+1);
        }

        return s;
    }

    private String trimCharsPostPlus(String s) {
        String result = s;
        int index = s.indexOf("+");
        if(index>=0) {
            return result.substring(0, index);
        }

        return s;
    }

    public static void main(String[] args) {
        String[] input = new String[]{
                "test.email+alex@leetcode.com","test.email.leet+alex@code.com"
        };
        Solution solution = new Solution();
        System.out.println(solution.numUniqueEmails(input));
    }
}
