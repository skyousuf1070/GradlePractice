import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TimeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldAssertSystemOutPrint() {
        System.out.print("hello");
        assertThat("hello", is(outContent.toString()));
    }

    @Test
    public void shouldIncrementSecondsByOneWhenTickMethodIsCalled() {
        Time time = new Time(12, 30, 45);
        time.tick();
        time.print();
        assertThat("12:30:46\n", is(outContent.toString()));
    }

    @Test
    public void shouldIncrementMinutesByOneWhenSecondsIsEqualTo60() {
        Time time = new Time(2, 8, 60);
        time.tick();
        time.print();
        assertThat("2:9:0\n", is(outContent.toString()));
    }

    @Test
    public void shouldIncrementHoursByOneWhenMinutesAndSecondsAreEqualTo60() {
        Time time = new Time(2, 60, 60);
        time.tick();
        time.print();
        assertThat("3:0:0\n", is(outContent.toString()));
    }

    @Test
    public void shouldResetHoursMinutesAndSecondsTo0WhenHoursIsEqualTo12AndMinutesAndSecondsAreEqualTo60() {
        Time time = new Time(12, 60, 60);
        time.tick();
        time.print();
        assertThat("0:0:0\n", is(outContent.toString()));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}