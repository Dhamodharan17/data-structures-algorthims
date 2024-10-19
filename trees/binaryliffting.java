class TreeAncestor {

    int[][] ancestor;
    int maxPower;

    public TreeAncestor(int n, int[] parent) {
        
       // number of levels i can have max based on binary
        maxPower=1;
        while((1<<maxPower)<=n) maxPower++;

        ancestor = new int[n][maxPower];

         // Fill the ancestor table
        for (int node = 0; node < n; node++) {
            ancestor[node][0] = parent[node]; // Direct parent
        }

        //fill table for indirect anchestor
        for(int i=1;i<maxPower;i++){//parent
            for(int node=0;node<n;node++){

                if(ancestor[node][i-1] != -1) {
                    int parentNode = ancestor[node][i-1];//nodes previous
                    ancestor[node][i] = ancestor[parentNode][i-1];//parent previous i.e anchestor
                }
                else{
                    ancestor[node][i] = -1;
                }
            }
        }//end of for
    }
    
    public int getKthAncestor(int node, int k) {
        
        for(int parent=0;parent<maxPower;parent++){

            if((k & (1<<parent)) !=0){//check parent exists usin binary form of k
                node = ancestor[node][parent];//move to 2^k ancestor
                if(node==-1) return -1;
            }

        }
    return node;
    }
}
