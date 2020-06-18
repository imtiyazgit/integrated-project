package algos.stack.maxApi;

public class StackMaxAPITest {
    //  4 99 4 1 3
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(99);
        stack.push(4);
        stack.push(-3);

        stack.pop();

        Integer max = stack.max();
        System.out.println(max); // 99;
    }
}
