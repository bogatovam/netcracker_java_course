package com.netcracker.MyPoint;

public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        return new int[]{x, y};
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double distance() {
        int dx = this.x;
        int dy = this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distance(int x, int y) {
        int dx = (this.x - x);
        int dy = (this.y - y);
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distance(MyPoint p) {
        int dx = (this.x - p.x);
        int dy = (this.y - p.y);
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPoint point = (MyPoint) o;

        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        int result = 14;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}
