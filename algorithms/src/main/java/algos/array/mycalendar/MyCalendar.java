package algos.array.mycalendar;
import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class MyCalendar {

    List intervals;
    PriorityQueue<Interval> minHeap;

    public MyCalendar() {
        this.intervals = new ArrayList<>();
        minHeap = new PriorityQueue<>((a,b) -> a.end - b.end);
    }

    public boolean book(int start, int end) {
        Interval interval = new Interval(start, end);
        if(!minHeap.isEmpty()) {
            Interval previousMeeting = minHeap.remove();
            if(interval.start >= previousMeeting.end) {
                minHeap.add(interval);
                return true;
            } else {
                minHeap.add(previousMeeting);
                return false;
            }
        } else {
            minHeap.add(interval);
        }

        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}
