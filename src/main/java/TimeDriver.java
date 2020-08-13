public class TimeDriver {
    public static void main(String[] args) {
        final Time time = new Time(2, 8, 6);
        final Time time1 = new Time(2, 8, 60);
        final Time time2 = new Time(2, 60, 60);
        final Time time3 = new Time(12, 8, 60);
        final Time time4 = new Time(12, 60, 60);
        time.tick();
        time1.tick();
        time2.tick();
        time3.tick();
        time4.tick();

        time.print();
        time1.print();
        time2.print();
        time3.print();
        time4.print();
    }
}
