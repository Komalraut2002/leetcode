class Solution {
   
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean [] visited = new boolean[n];
        int[] path = new int[n];
        int[] check = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i,visited,path,check,graph);
            }
        }
            for(int j=0;j<n;j++){
                if(check[j]==1){
                    ans.add(j);
            }
        }

        return ans;
    }

    boolean dfs(int i,boolean[]visited,int[] path,int[]check,int[][]graph) {
        visited[i] = true;
        path[i] = 1;
        check[i] = 0;

        for (int it : graph[i]) {
            if (!visited[it]) {
                if (dfs(it,visited,path,check,graph)) {
                    return true;
                }
            } else if (path[it] == 1) {
                return true;
            }
        }

        check[i] = 1;
        path[i] = 0;
        return false;
    }
}
