package algos.array.incrementinteger;

import java.util.ArrayList;
import java.util.List;

public class IncrementInteger {

    private static List<Integer> bruteForceAdd(List<Integer> list) {

        // Extract ints as strings and form a overall string
        StringBuilder strInputBuilder = new StringBuilder();
        for (Integer integer: list) {
            strInputBuilder.append(integer);
        }

        //Now that we can string form of input, lets add 1 to it and convert to a int
        int integerInput = Integer.parseInt(strInputBuilder.toString())+1;


        // Now you have int result, put that onto list
        String strInput = String.valueOf(integerInput);
        List<Integer> result = new ArrayList<>();

        for(char c:strInput.toCharArray()) {
            result.add(Character.getNumericValue(c));
        }

        return result;
    }

    private static List<Integer> increment(List<Integer> list) {
        int end = list.size()-1;

        // School days, how we add.. add that way.. for example add one to 9 and carry over to 2, like that
        list.set(end, list.get(end) + 1);

        for (int i = end; i > 0 && list.get(i) == 10; i--) {

            list.set(i, 0);

            list.set(i-1, list.get(i-1) + 1);

        }

        if(list.get(0) == 10) {
            list.set(0, 1);
            list.add(0);
        }


        return list;

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(9);
        list.add(9);
        list.add(9);

        List result = increment(list);

        System.out.println(result); // 1, 0, 0, 0

        List<Integer> list2 = new ArrayList();
        list2.add(9);
        list2.add(9);
        list2.add(9);

        result = bruteForceAdd(list2);
        System.out.println(result);



    }
}
