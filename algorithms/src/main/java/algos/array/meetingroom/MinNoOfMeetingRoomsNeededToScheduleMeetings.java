package algos.array.meetingroom;

import java.util.Arrays;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


public class MinNoOfMeetingRoomsNeededToScheduleMeetings {


    // [[1,10], [2,7], [3,19],[8,12], [10,20], [11,30]
    //  1        2      3     no need  no need  4
    public static int getMinNoOfRooms(Interval[] intervals) {
        if(intervals == null || intervals.length ==0 ){
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> a.start - b.start);

        PriorityQueue<Interval>  minHeap = new PriorityQueue<>((a,b) -> a.end - b.end);
        minHeap.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval current = intervals[i];
            Interval previous = minHeap.remove();

            if(current.start >= previous.end) {
                // You can use same meeting room and extend the end time
                previous.end = current.end;
            } else {
                // There is a conflict and you can not use same meeting room
                minHeap.add(current);
            }

            minHeap.add(previous);
        }

        return minHeap.size();

    }


    public static void main(String[] args) {
        Interval[] intervals = new Interval[] {
                new Interval(1, 10),
                new Interval(2,7),
                new Interval(3,19),
                new Interval(8,12),
                new Interval(10,20),
                new Interval(11,30),
        };

        System.out.println(getMinNoOfRooms(intervals));


    }


}
