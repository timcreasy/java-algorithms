/**
 * Created by timcreasy on 10/26/17.
 */

public class QuickUnion {

    private int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private int getRoot(int i) {
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }

    // To union, merge trees, set id of ps root to id of qs root
    public void union(int p, int q) {
        id[getRoot(p)] = getRoot(q);
    }

    //  Do p and q share the same root?
    public boolean connected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        qu.union(4, 3);
        qu.union(3, 8);
        qu.union(6, 5);
        qu.union(9, 4);
        qu.union(2, 1);
        System.out.println(qu.connected(8, 9));
        System.out.println(qu.connected(5, 4));
        qu.union(5, 0);
        qu.union(7, 2);
        qu.union(6, 1);
        qu.union(7, 3);
    }

}
