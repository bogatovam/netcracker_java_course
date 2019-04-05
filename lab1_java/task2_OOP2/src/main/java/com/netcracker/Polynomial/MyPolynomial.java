package com.netcracker.Polynomial;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        int lastIndex = coeffs.length - 1;
        while (lastIndex >= 0 && coeffs[lastIndex] == 0) lastIndex--;
        this.coeffs = new double[lastIndex + 1];
        for (int i = 0; i <= lastIndex; ++i)
            this.coeffs[i] = coeffs[i];
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coeffs.length - 1; i >= 0; --i) {
            if (Double.compare(coeffs[i], 0.0) != 0) {
                sb.append(" + " + coeffs[i]);
                if (i != 0) {
                    sb.append("*");
                    if (i == 1) {
                        sb.append("x");
                    } else {
                        sb.append("x^");
                        sb.append(i);
                    }
                }
            }
        }
        sb.delete(0,2);
        return sb.toString();
    }

    public double evaluate(double x) {
        double res = 0.0;
        for (int i = 0; i < coeffs.length; ++i) {
            res += coeffs[i] * Math.pow(x, i);
        }
        return res;
    }

    public MyPolynomial add(MyPolynomial right) {
        boolean lengthFlag = coeffs.length > right.coeffs.length;
        int lengthRes = lengthFlag ? coeffs.length : right.coeffs.length;
        double[] resCoeffs = new double[lengthRes];

        for (int i = 0; i < coeffs.length; ++i) {
            resCoeffs[i] = coeffs[i];
        }
        for (int i = 0; i < right.coeffs.length; ++i) {
            resCoeffs[i] += right.coeffs[i];
        }
        return new MyPolynomial(resCoeffs);
    }

    public MyPolynomial multiple(MyPolynomial right) {
        int lengthRes = getDegree() + right.getDegree() + 1;
        double[] resCoeffs = new double[lengthRes];
        for (int i = 0; i < coeffs.length; ++i) {
            for (int j = 0; j < right.coeffs.length; ++j) {
                resCoeffs[i + j] += coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(resCoeffs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        int result = 14;
        long temp;
        for (double el : coeffs) {
            temp = Double.doubleToLongBits(el);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
        }
        return result;
    }
}