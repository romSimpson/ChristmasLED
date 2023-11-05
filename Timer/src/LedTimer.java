import java.time.LocalTime;

public class LedTimer {
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean ledState;
    private int ledCount;

    public LedTimer(int ledCount, LocalTime startTime, LocalTime endTime) {
        this.ledCount = ledCount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ledState = false; // Initialize LED state as off
        initLedStrip();
    }

    private void initLedStrip() {
        // Implementation for initializing the LED strip
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void turnOn() {

        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
            ledState = true;
        } else {
            System.out.println("LED shouldn't be turned ON at this time.");
        }
    }

    public void turnOff() {
        ledState = false;
        // Control your LEDs here to turn them off
    }

    public boolean isLedOn() {
        return ledState;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
