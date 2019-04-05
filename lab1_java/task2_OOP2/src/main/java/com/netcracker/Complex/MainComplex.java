package com.netcracker.Complex;

public class MainComplex {
    public static void main(String[] args) {
        MyComplex number1 = new MyComplex(1, 5);
        MyComplex number2 = new MyComplex(2, 0.5);
        MyComplex number3 = new MyComplex(-3, 0.1);

        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);

        System.out.println("Num1 and Num2 are " + (number1.equals(number2) ? " equals " : " not equals "));
        System.out.println("Num2 and Num3 are " + (number2.equals(number3) ? " equals " : " not equals "));
        System.out.println("Magnitude " + number1 + " is " + number1.magnitude());
        System.out.println("Argument " + number1 + " is " + number1.argument());
        System.out.println("Conjugate " + number1 + " is " + number1.conjugate());
        System.out.println(number1 + " + " + number2 + "= " + number1.addNew(number2));
        System.out.println(number2 + " * " + number3 + "= " + number2.substactNew(number3));
        System.out.println(number3 + " / " + number1 + "= " + number3.divide(number1));
    }
}
