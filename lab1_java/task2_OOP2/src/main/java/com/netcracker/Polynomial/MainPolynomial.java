package com.netcracker.Polynomial;

public class MainPolynomial {
    public static void main(String[] args) {
        MyPolynomial polynomial1 = new MyPolynomial(4, 5, 1);
        MyPolynomial polynomial2 = new MyPolynomial(0, 2, 2, 1);
        MyPolynomial polynomial3 = new MyPolynomial(0, 2, 2, 1);

        System.out.println(polynomial1);
        System.out.println(polynomial2);

        System.out.println("polynomial1  and polynomial2  are " + (polynomial1.equals(polynomial2) ? " equals " : " not equals "));
        System.out.println("Calculated by a polynomial1 with a value of 5 " + polynomial1.evaluate(5));
        System.out.println("Calculated by a polynomial2 with a value of 5 " + polynomial2.evaluate(5));
        System.out.println("The multiple of the first and second polynomial " + polynomial2.multiple(polynomial1));
        System.out.println("The sum of the first and second polynomial " + polynomial1.add(polynomial2));
    }
}
