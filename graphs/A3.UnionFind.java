class Solution {

    class DSU{
        int[] parent;
        int[] rank;
        int comp;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            comp=n;
            for(int i=0;i<n;i++)
                parent[i] =i;
        }

        int find(int x){
            if(x==parent[x]) return x;

            return find(parent[x]);
        }

        void union(int x,int y){
            int px = find(x);
            int py = find(y);

            if(px==py) return;
            comp--;
            if(rank[px]> rank[py]){
                parent[py] = px;
            }else if(rank[py]>rank[px]){
                parent[px] = py;
            }else{
                parent[py] =px;
                rank[px]++;
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DSU dsu = new DSU(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j] ==1){
                    dsu.union(i,j);
                }
            }
        }

        return dsu.comp;
    }
}
