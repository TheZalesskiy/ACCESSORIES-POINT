package theZalesskiy;


import java.util.ArrayList;
import java.util.List;

/*
accessories point rectengle
 */
class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Point> rectengle = new ArrayList<>();
        //coordinates of its vertex
        rectengle.add(new Point(0, 0));
        rectengle.add(new Point(0, 10));
        rectengle.add(new Point(10, 10));
        rectengle.add(new Point(10, 0));

        System.out.println(isPointInRectengle(new Point(4, 4), rectengle));
        System.out.println(isPointInRectengle(new Point(200, 200), rectengle));
    }

    public static boolean isPointInRectengle(Point point, List<Point> rectengle) {
        int mCheck = 1;
        for (int i = 0; i < rectengle.size(); i++) {
            Point a = rectengle.get(i);
            Point b;
            if (i == rectengle.size() - 1) {
                b = rectengle.get(0);
            } else {
                b = rectengle.get(i + 1);
            }
            mCheck *= check(a, b, point);
        }
        return mCheck != 1;
    }

    /*
    The program should return 0 if the point lies on the boundary of the rectengle,
    otherwise the need to  1, if the point is outside the rectengle,
    and -1 if the point lies inside the rectengle.
    */
    private static int check(Point a, Point b, Point point) {
        long ax = a.x - point.x;
        long ay = a.y - point.y;
        long bx = b.x - point.x;
        long by = b.y - point.y;
        int s = Long.signum(ax * by - ay * bx);
        if (s == 0 && (ay == 0 || by == 0) && ax * bx <= 0)
            return 0;
        if (ay < 0 ^ by < 0) {
            if (by < 0)
                return s;
            return -s;
        }
        return 1;
    }
}
