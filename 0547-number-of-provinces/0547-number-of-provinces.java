class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int count=0; 
        boolean [] visited=new boolean[n];
        for(int i=0;i<n;i++){
                if(!visited[i]){
                    count++;
                    dfs(isConnected,i,visited);
                }
            }
        return count;
   }
   private static void dfs(int[][] isConnected, int idx,boolean[]visited) {
       int n=isConnected.length;
       HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
            }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (isConnected[i][j]==1 && i!=j){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
       visited[idx]=true;
            for (int it:map.get(idx)) {
                if (!visited[it]) {
                    visited[it] = true;
                    dfs(isConnected, it,visited);
                }
            }
        }
    }