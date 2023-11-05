public class localTime {
    private int hour;
    private int minute;

    public localTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean isAfter(localTime other) {
        if (this.hour > other.hour) {
            return true;
        } else if (this.hour == other.hour && this.minute > other.minute) {
            return true;
        }
        return false;
    }

    public boolean isBefore(localTime other) {
        if (this.hour < other.hour) {
            return true;
        } else if (this.hour == other.hour && this.minute < other.minute) {
            return true;
        }
        return false;
    }

    public static localTime now() {

        return new localTime(12, 0);
    }

    public static localTime of(int hour, int minute) {
        return new localTime(hour, minute);
    }
}
