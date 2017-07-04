package main.java.com.hashing;

import java.util.HashSet;
import java.util.Set;

class PhoneNumber {

    private final String name;
    private String number;

    public PhoneNumber(String number, String name) {
        this.number = number;
        this.name = name;
    }

    // Setter makes "number" mutable!
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result +
                (number != null ? number.hashCode() : 0);
        return result;
    }

    // equals() left out here ...
}


public class MutableHashSetProblem {

    public static void main(String[] args) {
        // Class PhoneNumber implements hashCode() and equals()
        PhoneNumber obj = new PhoneNumber("mgm", "089/358680");
        System.out.println("Hashcode: " +
                obj.hashCode());  //prints "1476725853"

        // Add PhoneNumber object to HashSet
        Set<PhoneNumber> set = new HashSet();
        set.add(obj);

        // Modify object after it has been inserted
        obj.setNumber("089/358680-0");

        // Modification causes a different hash value
        System.out.println("New hashcode: " +
                obj.hashCode()); //prints "7130851"

        // ... Later or in another class, code such as the following
        // is operating on the Set:

        // Unexpected Result!
        // Output: obj is set member: FALSE
        System.out.println("obj is set member: " +
                set.contains(obj));

        // Even stranger unexpected Result!
        // Output: obj is set member: FALSE
        for (PhoneNumber p : set) {
            if (p.equals(obj)) {
                System.out.println("obj is set member: " +
                        set.contains(p));
            }
        }

        Object o = 3.0/2;

        System.out.println(o);
    }
}
