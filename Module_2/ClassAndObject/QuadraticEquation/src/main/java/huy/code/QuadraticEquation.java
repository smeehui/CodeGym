package huy.code;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.setA(a);
        this.setB(b);
        this.setC(c);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return this.c;
    }

    public void setC(double c) {
        this.c = c;
    }

    double getDiscriminant() {
        return this.getB() * this.getB() - 4 * this.getA() * this.getC();
    }

    double getRoot1() {
        return this.getDiscriminant() >= 0 ? (-this.getB()) + Math.sqrt(this.getDiscriminant()) : 0;
    }

    double getRoot2() {
        return this.getDiscriminant() >= 0 ? (-this.getB()) - Math.sqrt(this.getDiscriminant()) : 0;
    }

    String getEquation() {
        return "Input equation: " + (this.getA() != 0.0 ? this.getA() + "x^2 " : "")
                + (this.getB() != 0.0 ? this.getB() + "x " : "+")
                + (this.getC() != 0.0 ? String.valueOf(this.getC()) : "")
                + " = 0";
    }

    String calculateRoots() {
        if (this.getA() == 0) return "Invalid quadratic equation";
        else if (this.getDiscriminant() < 0) return "The equation has no root";
        else if (this.getDiscriminant() == 0) return "The equation has two equal roots:" + this.getRoot1();
        else return "The equation has two different root:\n" + "r1: " + this.getRoot1() + "\nr2: " + this.getRoot2();
    }
}
