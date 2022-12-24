import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzStringExtendedTest {

    @org.junit.jupiter.api.Test
    void translate1() {
        String expected = FizzBuzzStringExtended.FIZZ;
        assertEquals(expected, new FizzBuzzStringExtended(3).translate());
    }
    @org.junit.jupiter.api.Test
    void translate2() {
        String expected = FizzBuzzStringExtended.BUZZ;
        assertEquals(expected, new FizzBuzzStringExtended(5).translate());
    }
    @org.junit.jupiter.api.Test
    void translate3() {
        String expected = FizzBuzzStringExtended.FizzBuzz;
        assertEquals(expected, new FizzBuzzStringExtended(35).translate());
    }
    @org.junit.jupiter.api.Test
    void translate4() {
        String expected = "một";
        assertEquals(expected, new FizzBuzzStringExtended(1).translate());
    }
    @org.junit.jupiter.api.Test
    void translate5() {
        String expected = "hai mươi sáu";
        assertEquals(expected, new FizzBuzzStringExtended(26).translate());
    }@org.junit.jupiter.api.Test
    void translate6() {
        String expected = "mười một";
        assertEquals(expected, new FizzBuzzStringExtended(11).translate());
    }
    @org.junit.jupiter.api.Test
    void translate7() {
        String expected = "mười";
        assertEquals(expected, new FizzBuzzStringExtended(10).translate());
    }
    @org.junit.jupiter.api.Test
    void translate8() {
        String expected = "hai mươi";
        assertEquals(expected, new FizzBuzzStringExtended(20).translate());
    }
}