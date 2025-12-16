import java.util.*;

class Solution {

    int n, budget;
    int[] present, future;
    List<Integer>[] tree;

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.n = n;
        this.present = present;
        this.future = future;
        this.budget = budget;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] h : hierarchy) {
            tree[h[0] - 1].add(h[1] - 1);
        }

        long[][][] memo = new long[n][2][];
        boolean[][] seen = new boolean[n][2];

        long[] res = dp(0, -1, memo, seen)[0];

        long ans = 0;
        for (long v : res) ans = Math.max(ans, v);
        return (int) ans;
    }

    private long[][] dp(int u, int parent, long[][][] memo, boolean[][] seen) {

        if (seen[u][0]) return memo[u];
        seen[u][0] = true;

        long[] noDiscount = new long[budget + 1];
        long[] withDiscount = new long[budget + 1];

        Arrays.fill(noDiscount, 0);
        Arrays.fill(withDiscount, 0);

        for (int v : tree[u]) {
            if (v == parent) continue;

            long[][] child = dp(v, u, memo, seen);
            noDiscount = merge(noDiscount, child[0]);
            withDiscount = merge(withDiscount, child[1]);
        }

        long[] newDp0 = noDiscount.clone();
        long[] newDp1 = noDiscount.clone();

        int fullCost = present[u];
        int fullProfit = future[u] - fullCost;
        for (int b = fullCost; b <= budget; b++) {
            newDp0[b] = Math.max(newDp0[b], withDiscount[b - fullCost] + fullProfit);
        }

        int halfCost = present[u] / 2;
        int halfProfit = future[u] - halfCost;
        for (int b = halfCost; b <= budget; b++) {
            newDp1[b] = Math.max(newDp1[b], withDiscount[b - halfCost] + halfProfit);
        }

        memo[u] = new long[][]{newDp0, newDp1};
        return memo[u];
    }

    private long[] merge(long[] a, long[] b) {
        long[] res = new long[a.length];
        Arrays.fill(res, Long.MIN_VALUE / 4);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j + i < a.length; j++) {
                res[i + j] = Math.max(res[i + j], a[i] + b[j]);
            }
        }
        return res;
    }
}
