public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void tick() {
        if (hours == 12 && minutes == 60 && seconds == 60) {
            hours = 0;
            minutes = 0;
            seconds = 0;
        } else if (hours < 12 && minutes == 60 && seconds == 60) {
            hours++;
            minutes = 0;
            seconds = 0;
        } else if (hours <= 12 && minutes < 60 && seconds == 60) {
            minutes++;
            seconds = 0;
        } else {
            seconds++;
        }
    }

    public void print() {
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}
