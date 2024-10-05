class Solution {

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            comp = n;
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            return find(parent[x]);
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            // already both on same set
            if (px == py)
                return;
            comp--;
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[py] < rank[px]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }

    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        DSU dsu = new DSU(n);
        int count = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && dsu.find(i) != dsu.find(j)) {
                    dsu.union(i, j);
                    count--;
                }
            }
        }

        return count;
    }
}
