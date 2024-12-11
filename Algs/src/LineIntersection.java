public class LineIntersection {

    public static void main(String[] args) {

        int a1 = 1, b1 = -1, c1 = 0;
        int a2 = 1, b2 = 1, c2 = 2;

        findIntersection(a1, b1, c1, a2, b2, c2);
    }


    public static boolean findIntersection(int a1, int b1, int c1, int a2, int b2, int c2) {

        int determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            System.out.println("Lines are parallel and do not intersect.");
            return false;
        }

        int x = (c1 * b2 - c2 * b1) / determinant;
        int y = (a1 * c2 - a2 * c1) / determinant;

        System.out.println("The intersection point is: (" + x + ", " + y + ")");
        return true;
    }



}
