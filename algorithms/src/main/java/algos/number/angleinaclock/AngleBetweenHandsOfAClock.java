package algos.number.angleinaclock;

public class AngleBetweenHandsOfAClock {

    private static final double MINUTE_PER_HOUR = 60;
    private static final double DEGREES_PER_MINUTE = 360/MINUTE_PER_HOUR;

    private static final double DEGREES_PER_HOUR = 360/12;

    private static double clockAngle(int hour, int minutes) {

        double minuteAngle = minutes * DEGREES_PER_MINUTE;

        double hourAngle = hour * DEGREES_PER_HOUR + (minutes/MINUTE_PER_HOUR) * DEGREES_PER_HOUR;

        double diff = Math.abs(minuteAngle - hourAngle);

        if(diff > 180) {
            return 360 - diff;
        }

        return diff;

    }

    public static void main(String[] args) {
        System.out.println(clockAngle(11, 10));
    }
}
