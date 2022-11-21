import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzStringTest {

    @org.junit.jupiter.api.Test
    void translate1() {
        String expected = FizzBuzzString.FIZZ;
        assertEquals(expected, new FizzBuzzString(3).translate());
    }
    @org.junit.jupiter.api.Test
    void translate2() {
        String expected = FizzBuzzString.BUZZ;
        assertEquals(expected, new FizzBuzzString(5).translate());
    }
    @org.junit.jupiter.api.Test
    void translate3() {
        String expected = FizzBuzzString.FizzBuzz;
        assertEquals(expected, new FizzBuzzString(15).translate());
    }
    @org.junit.jupiter.api.Test
    void translate4() {
        String expected = "1";
        assertEquals(expected, new FizzBuzzString(1).translate());
    }
    @org.junit.jupiter.api.Test
    void translate5() {
        String expected = "26";
        assertEquals(expected, new FizzBuzzString(26).translate());
    }
}