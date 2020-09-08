package algos.array.leastinterval;

import java.util.*;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        int[] char_map = new int[26];
        for(char c:tasks) {
            char_map[c-'A']++;
        }

        // 0,0,0,...3,3
        Arrays.sort(char_map);
        // find how many max slots can be adjusted between the max task
        int max_slots = (char_map[25] -1) * n;

        // Start filling the slots from max
        for(int i=24; i>=0;i--) {
            max_slots = max_slots -  Math.min(char_map[i], char_map[25] -1);
        }

        if(max_slots > 0) {
            // there are left over slots
            return max_slots + tasks.length;
        } else {
            return tasks.length;
        }

    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A',
                'B', 'C', 'D', 'E', 'F', 'G'}, 2));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
    }
}
