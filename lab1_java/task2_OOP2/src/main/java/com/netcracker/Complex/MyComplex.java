package com.netcracker.Complex;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real +
                "+" + imag +
                "i)";
    }

    public boolean isReal() {
        return real != 0;
    }

    public boolean isImaginary() {
        return imag != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyComplex myComplex = (MyComplex) o;
        return Double.compare(myComplex.real, real) == 0 &&
                Double.compare(myComplex.imag, imag) == 0;
    }

    public boolean equals(double real, double imag) {
        MyComplex myComplex = new MyComplex(real, imag);
        return Double.compare(myComplex.real, real) == 0 &&
                Double.compare(myComplex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        int result = 14;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imag);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double argument() {
        return Math.atan(imag / real);
    }

    public MyComplex add(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(real + right.real, imag + right.imag);
    }

    public MyComplex substact(MyComplex right) {
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex substactNew(MyComplex right) {
        return new MyComplex(real - right.real, imag - right.imag);
    }

    public MyComplex multiply(MyComplex right) {
        this.real = real * right.real - imag * right.imag;
        this.imag = real * right.imag + imag * right.real;
        return this;
    }

    public MyComplex divide(MyComplex right) {
        this.real = (real * right.real + imag * right.imag) /
                right.real * right.real + right.imag * imag;
        this.imag = (right.real * imag - real * right.imag) /
                right.real * right.real + right.imag * imag;
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(real, -imag);
    }

}
