// Java equivalent of the above code
import java.util.*;

public class GrahamScan{
    // Define Infinite (Using INT_MAX
    // caused overflow problems)
    static final int INF = 10000;

    public static void main(String[] args)
    {
        Pointt points[] = new Pointt[8];
        points[0] = new Pointt(0, 3);
        points[1] = new Pointt(1, 1);
        points[2] = new Pointt(2, 2);
        points[3] = new Pointt(4, 4);
        points[4] = new Pointt(0, 0);
        points[5] = new Pointt(1, 2);
        points[6] = new Pointt(3, 1);
        points[7] = new Pointt(3, 3);

        int n = points.length;
        convexHull(points, n);
    }

    // To find orientation of ordered triplet (p, q, r). 
    // The function returns following values 
    // 0 --> p, q and r are colinear 
    // 1 --> Clockwise 
    // 2 --> Counterclockwise 
    static int orientation(Pointt p, Pointt q, Pointt r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0;

        return (val > 0)? 1: 2;
    }

    static void convexHull(Pointt points[], int n) {
        // There must be at least 3 points 
        if (n < 3) return;

        // Initialize Result 
        Vector<Pointt> hull = new Vector<Pointt>();

        // Find the leftmost point 
        int l = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[l].x)
                l = i;

        int p = l, q;
        do
        {
            hull.add(points[p]);

            q = (p + 1) % n;

            for (int i = 0; i < n; i++)
            {
                if (orientation(points[p], points[i], points[q]) == 2) {

                    q = i;
                }
            }

            p = q;

        } while (p != l);

        for (int i = 0; i < hull.size(); i++)
            System.out.println("(" + hull.get(i).x + ", " + hull.get(i).y + ")");
    }


}

//Point class to store points 
class Pointt {
    int x, y;
    Pointt()
    {
        x = 0;
        y = 0;
    }
    Pointt(int a, int b)
    {
        x = a;
        y = b;
    }
}