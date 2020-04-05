package algos.array.arrayintegermultiplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayIntegerMultiplication {


    private static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

        for (int i = num1.size() - 1; i >= 0 ; --i) {
            for (int j = num2.size() -1; j >=0 ; --j) {

                int temp1 = num1.get(i);
                int temp2 = num2.get(j);
                int mul = temp1 * temp2;

                result.set(i + j + 1, result.get(i + j + 1) + num2.get(j) * num1.get(i));
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
                System.out.println("Next iter");
            }
            System.out.println("Outer iter");
        }

        int firstNotZero = 0;
        while (firstNotZero < result.size() && result.get(firstNotZero) == 0) {
            ++firstNotZero;
        }
        result = result.subList(firstNotZero, result.size());
        if( result.isEmpty()) {
            //return List.of(0);
            return null;
        }
        result.set(0, result.get(0) * sign);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> num1 = new ArrayList<>();
        num1.add(1);
        num1.add(2);
        num1.add(3);

        List<Integer> num2 = new ArrayList<>();
        num2.add(9);
        num2.add(8);
        num2.add(7);

        List<Integer> result = multiply(num1, num2);

        System.out.println(result);


    }
}
