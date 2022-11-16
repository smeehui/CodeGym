package org.example;

import java.util.Arrays;

public class Point3D extends Point2D {

    private float z = 0.0f;
    private float[] XYZ = new float[3];

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x,y);
        setX(x);
        setY(y);
        setZ(z);
        this.setXYZ(getX(), getY(), this.getZ());
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        this.XYZ[0] = x;
        this.XYZ[1] = y;
        this.XYZ[2] = z;
    }

    public float[] getXYZ() {
        return this.XYZ;
    }

    public String toString() {
        return "3D coordinates "+ Arrays.toString(this.getXYZ())+", "+ super.toString();
    }

}