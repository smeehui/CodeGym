public class TriangleClassifier {
    public static final String ISOSCELES_TRIANGLE = "Tam giác cân";
    public static final String EQUILATERAL_TRIANGLE = "Tam giác đều";
    public static final String REGULAR_TRIANGLE = "Tam giác thường";
    public static final String NOT_A_TRIANGLE = "Không phải là tam giác";
    private double side1;
    private double side2;
    private double side3;

    public TriangleClassifier() {

    }

    public TriangleClassifier(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public String classify() {
        if(this.getSide1()<=0||this.getSide2()<=0||this.getSide3()<=0) return NOT_A_TRIANGLE;
        if(this.getSide1()+this.getSide2()>this.getSide3()&&this.getSide1()+this.getSide3()>this.getSide2()&&this.getSide3()+this.getSide2()>this.getSide1()){
            if (this.getSide1() == this.getSide2()&& this.side1 == this.getSide3() &&this.getSide3()==this.getSide2()) return EQUILATERAL_TRIANGLE;
            if (this.getSide1() == this.getSide2() || this.getSide1() == this.getSide3() || this.getSide2() == this.getSide3()) return ISOSCELES_TRIANGLE;
            return REGULAR_TRIANGLE;
        }
        else return NOT_A_TRIANGLE;
    }
    public double getSide1() {
        return side1;
    }


    public double getSide2() {
        return side2;
    }



    public double getSide3() {
        return side3;
    }

}
