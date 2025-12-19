import java.util.*;

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;   
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]); 
        }
        return parent[u];
    }

    public void unionByRank(int u, int v) {
        int i = find(u);
        int j = find(v);

        if (i == j) return;

        if (rank[i] < rank[j]) {
            parent[i] = j;
        } else if (rank[i] > rank[j]) {
            parent[j] = i;
        } else {
            parent[i] = j;
            rank[j]++;
        }
    }

    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }

    public void reset(int u) {
        parent[u] = u;
    }
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        UnionFind uf = new UnionFind(n);

        // TreeMap keeps times sorted (same as map in C++)
        Map<Integer, List<int[]>> timeToPairs = new TreeMap<>();

        uf.unionByRank(0, firstPerson);

        for (int[] meeting : meetings) {
            int x = meeting[0];
            int y = meeting[1];
            int time = meeting[2];

            timeToPairs
                .computeIfAbsent(time, k -> new ArrayList<>())
                .add(new int[]{x, y});
        }

        for (List<int[]> pairs : timeToPairs.values()) {
            Set<Integer> peopleUnioned = new HashSet<>();

            for (int[] pair : pairs) {
                int x = pair[0];
                int y = pair[1];

                uf.unionByRank(x, y);
                peopleUnioned.add(x);
                peopleUnioned.add(y);
            }

            for (int person : peopleUnioned) {
                if (!uf.connected(person, 0)) {
                    uf.reset(person);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (uf.connected(i, 0)) {
                ans.add(i);
            }
        }

        return ans;
    }
}
