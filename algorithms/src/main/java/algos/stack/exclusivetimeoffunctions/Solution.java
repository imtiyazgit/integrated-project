package algos.stack.exclusivetimeoffunctions;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
class LogLine {
    int id;
    boolean isStart;
    int time;

    // "0:start:0"
    public LogLine(String[] aLog) {
        this.id = Integer.parseInt(aLog[0]);
        this.isStart = aLog[1].equals("start");
        this.time = Integer.parseInt(aLog[2]);
    }
}
public class Solution {
    public static int[] exclusiveTime(int n, List < String > logs) {

        int[] totalTime = new int[n];

        Stack<LogLine> stack = new Stack<>();
        int prevTime=0;

        for(String str: logs) {
            LogLine log = new LogLine(str.split(":"));
            if(log.isStart) {
                if(!stack.isEmpty()) {
                    LogLine prevLogLine = stack.peek();
                    totalTime[prevLogLine.id] += log.time - prevTime;
                }
                prevTime = log.time;
                stack.push(log);
            } else {
                totalTime[log.id] += log.time - prevTime + 1;
                prevTime = log.time + 1;
                stack.pop();
            }
        }

        return totalTime;
    }




    public static void main(String[] args) {
        String[] input = {"0:start:0","1:start:2","1:end:5","0:end:6"};
        System.out.println(Arrays.toString(exclusiveTime(2, Arrays.asList(input))));
    }
}