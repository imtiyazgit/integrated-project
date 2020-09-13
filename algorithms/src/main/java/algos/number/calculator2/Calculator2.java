package algos.number.calculator2;

public class Calculator2 {

    public static int calculate(String s) {
        if (s==null || s.length() == 0) {
            return 0;
        }

        int num=0, sum=0, tempSum = 0;
        char lastSign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);

            if(Character.isDigit(c)) {
                num = num * 10 +    c - '0';
            }

            if((!Character.isDigit(c) && c != ' ') || (i == s.length() -1)) {
                switch (lastSign) {
                    case '+':
                        sum+= tempSum;
                        tempSum = num;
                        break;
                    case '-':
                        sum+= tempSum;
                        tempSum = -num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;
                }
                lastSign = c;
                num = 0;
            }
        }

        sum += tempSum;

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3-22*2+3-1"));
    }
}
