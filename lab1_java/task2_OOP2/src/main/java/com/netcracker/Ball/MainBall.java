package com.netcracker.Ball;

public class MainBall {
    public static void main(String[] args) throws InterruptedException {
        Ball ball1 = new Ball(50, 50, 10, 10, 30);
        Ball ball2 = new Ball(20, 0, 10, 4, 10);

        Container container = new Container(0, 0, 100, 100);
        System.out.println(ball1);
        System.out.println(ball2);

        System.out.println("Ball1 and Ball 2 are "
                + (ball1.equals(ball2) ? " equals " : " not equals "));

        while (container.collides(ball1)) {
            ball1.move();
            System.out.println(ball1);
            Thread.sleep(500);
        }
        if (ball1.getX() + ball1.getRadius() > container.getX() + container.getWidth() ||
                ball1.getX() - ball1.getRadius() < container.getX()) {
            System.out.println("\nThe ball changed its horizontal direction\n");
            ball1.reflectHorizontal();
            ball1.move();
        } else {
            System.out.println("\nThe ball changed its vertical direction\n");
            ball1.reflectVertical();
            ball1.move();
        }
        while (container.collides(ball1)) {
            ball1.move();
            System.out.println(ball1);
            Thread.sleep(500);
        }
    }
}
