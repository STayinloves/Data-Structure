package Point;

class Point<T> {
    private T x;
    private T y;

    public Point(T _x, T _y) {
        this.x = _x;
        this.y = _y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public static void main(String[] args) {
        Point<Integer> p = new Point<Integer>(1, 2);
        System.out.println(p);
    }
}