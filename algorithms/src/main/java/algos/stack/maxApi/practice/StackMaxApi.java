package algos.stack.maxApi.practice;

public class StackMaxApi {


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(-1);
        stack.push(8);
        stack.push(4);
        stack.push(5);
        stack.push(33);
        stack.push(8);


        stack.pop();
        stack.pop();

        stack.push(3);

        System.out.println(stack.max());

        System.out.println("all done");
    }
}
