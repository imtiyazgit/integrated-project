package algos.string.removeminparanthesistomakeitvalid;

public class RemoveMinParanthesisToMakeStringValid {

    // s = (le(eet)code))is((
    // s = (le(eet)code)is
    private static String removeMinParanthesisToMakeStringValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open=0;

        for(char c:s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if(c == ')') {
                if(open == 0) {
                    continue;
                }
                open--;
            }
            sb.append(c);
        }

        StringBuilder result = new StringBuilder();

        for (int i = sb.length()-1; i >=0 ; i--) {
            if(sb.charAt(i) == '(' && open-- >0) {
                continue;
            }
            result.append(sb.charAt(i));
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeMinParanthesisToMakeStringValid("(le(eet)code))is(("));
    }
}
