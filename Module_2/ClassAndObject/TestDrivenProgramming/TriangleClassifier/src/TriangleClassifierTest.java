import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @org.junit.jupiter.api.Test
    void classify1() {
        double[] sides = {2,2,2};
        TriangleClassifier test = new TriangleClassifier(sides[0], sides[1], sides[2]);
        String expected = TriangleClassifier.EQUILATERAL_TRIANGLE;
        assertEquals(expected, test.classify());
    }
    @org.junit.jupiter.api.Test
    void classify2() {
        double[] sides = {2,2,3};
        TriangleClassifier test = new TriangleClassifier(sides[0], sides[1], sides[2]);
        String expected = TriangleClassifier.ISOSCELES_TRIANGLE;
        assertEquals(expected, test.classify());
    }
    @org.junit.jupiter.api.Test
    void classify3() {
        double[] sides = {3,4,5};
        TriangleClassifier test = new TriangleClassifier(sides[0], sides[1], sides[2]);
        String expected = TriangleClassifier.REGULAR_TRIANGLE;
        assertEquals(expected, test.classify());
    }
    @org.junit.jupiter.api.Test
    void classify4() {
        double[] sides = {8,2,3};
        TriangleClassifier test = new TriangleClassifier(sides[0], sides[1], sides[2]);
        String expected = TriangleClassifier.NOT_A_TRIANGLE;
        assertEquals(expected, test.classify());
    }
    @org.junit.jupiter.api.Test
    void classify5() {
        double[] sides = {-1,2,1};
        TriangleClassifier test = new TriangleClassifier(sides[0], sides[1], sides[2]);
        String expected = TriangleClassifier.NOT_A_TRIANGLE;
        assertEquals(expected, test.classify());
    }
    @org.junit.jupiter.api.Test
    void classify6() {
        double[] sides = {0,1,1};
        TriangleClassifier test = new TriangleClassifier(sides[0], sides[1], sides[2]);
        String expected = TriangleClassifier.NOT_A_TRIANGLE;
        assertEquals(expected, test.classify());
    }
}