public class HanoiTower {

    public static void main(String args[]) {
        int N = 3;

        towerOfHanoi(N, 'A', 'C', 'B');
    }

    static void towerOfHanoi(int n, char from_peg, char to_peg, char aux_peg) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from_peg, aux_peg, to_peg);
        System.out.println("Move disk " + n + " from rod " + from_peg + " to rod " + to_peg);
        towerOfHanoi(n - 1, aux_peg, to_peg, from_peg);
    }

}
