package Algs2;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
    public static LinkedList<Integer> maList = new LinkedList<>();

    public static void main(String[] args) throws URISyntaxException {
        maList.add(1);
//        f(5);
        System.out.println(f(4));
//        Scanner sc = new Scanner(System.in);
//        System.out.print("input array len: ");
//        int n = sc.nextInt();
//        System.out.println("Input array items: ");
//        ArrayList<Integer> array = new ArrayList<>();
//        for ( int i = 0; i < n; i++ ) {
//            array.add(sc.nextInt());
//        }
        /*
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(2);
        ar.add(5);
        ar.add(4);
        ar.add(11);
        ar.add(17);
        ar.add(1);
        ar.add(16);

        System.out.println(findIndexVerySimpleMethod(ar,27));
        */

//        Graph<URI, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
//
//        URI google = new URI("http://www.google.com");
//        URI wikipedia = new URI("http://www.wikipedia.org");
//        URI jgrapht = new URI("http://www.jgrapht.org");
//
//        // add the vertices
//        g.addVertex(google);
//        g.addVertex(wikipedia);
//        g.addVertex(jgrapht);
//
//        // add edges to create linking structure
//        g.addEdge(jgrapht, wikipedia);
//        g.addEdge(google, jgrapht);
//        g.addEdge(google, wikipedia);
//        g.addEdge(wikipedia, google);
//
//        System.out.println(g);


    }

    public static Integer f(Integer n) {
        if (maList.size() >= n) {
            return maList.get(n-1);
        }
        else {
            for (int i = maList.size(); i < n + 1; i++) {
                int a = maList.getLast();
                a *= i;
                maList.add(a);
            }

            return maList.get(n);
        }
    }

    public static ArrayList<Integer> findIndexVerySimpleMethod(ArrayList<Integer> ar, Integer target) {
        int n = ar.size();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (target.equals(ar.get(i) + ar.get(j))) {
                    ans.add(i);
                    ans.add(j);
                    return ans;
                }
            }
        }
        return ans;
    }


    //[2,6,5,4,11,8]   target - 17
    public static ArrayList<Integer> findIndex2(ArrayList<Integer> ar, Integer target) {
        return null;
    }
}
