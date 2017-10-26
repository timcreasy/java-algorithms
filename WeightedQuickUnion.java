/**
 * Created by timcreasy on 10/26/17.
 */

// Avoid large trees, balance by linking root of smaller tree to root of larger tree when performing union
// Connected impl remains the same as QuickUnion, union takes into account a size array to make above decision

public class WeightedQuickUnion {

    private int[] id;
    private int[] size;

    public WeightedQuickUnion(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            // Initial size for everything is 1, itself
            size[i] = 1;
        }
    }

    private int getRoot(int i) {
        while (id[i] != i) {
            // Make every other node in path to root point to grand parent, ha
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    // To union, merge trees, set id of ps root to id of qs root
    public void union(int p, int q) {
        int i = getRoot(p);
        int j = getRoot(q);
        // No work to be done if already joined
        if (i == j) return;
        // Link root of smaller tree to root of larger tree, and increase size accordingly
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id [j] = i;
            size[i] += size[j];
        }
    }

    //  Do p and q share the same root?
    public boolean connected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public static void main(String[] args) {
        WeightedQuickUnion qu = new WeightedQuickUnion(10);
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

