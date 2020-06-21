package algos.stack.simplifydirectorypath;

import java.util.*;

public class DirectoryPathNormalization {

    public static String shortestEquivalentPath(String path) {
        if (path.equals("")) {
            throw new IllegalArgumentException("invalid input");
        }

        Deque<String> stack = new ArrayDeque<>();
        String[] test = path.split("/");

        for (String token:path.split("/")) {
            if (!stack.isEmpty() && token.equals("..")) {
                // .. remove element from stack only if the stack is not empty
                stack.removeFirst();
            } else if(!token.equals(".") && !token.equals("..") && !token.equals("")){
                // split can produce space elements. we dont want to add
                stack.addFirst(token);
            }
        }

        if(stack.isEmpty()) {
            return "/";
        }
        String result = "";
        Iterator it = stack.descendingIterator();
        while(it.hasNext()) {
            result += "/" + it.next();
        }
        return result;
    }

    public static void main(String[] args) {
        String test1= "/home/";
        String test2= "/../";
        String test3= "/home//foo/";
        String test4= "/a/./b/../../c/d/";
        System.out.println(shortestEquivalentPath(test1)); // /home
        System.out.println(shortestEquivalentPath(test2));// /
        System.out.println(shortestEquivalentPath(test3));// /home/foo
        System.out.println(shortestEquivalentPath(test4));// /c/d
    }
}
