class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m=connections.length;
        int count=0;
        if(m<n-1){
            return -1;
        }
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean [] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
               dfs(visited,adj,i);
               count++;
            }
        }
        return count-1;
    }
    public void dfs(boolean[]visited,HashMap<Integer,ArrayList<Integer>> adj,int i){
        visited[i]=true;
        for(int it:adj.get(i)){
            if(!visited[it]){
                dfs(visited,adj,it);
            }
        }
    }
}