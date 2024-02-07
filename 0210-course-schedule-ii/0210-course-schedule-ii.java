class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if(dfs(i, visited, adj, st,path)){
                    return new int[0];
                }
            }
        }

        int index = 0;
        while (!st.isEmpty()) {
            ans[index++] = st.pop();
        }
        return ans;
    }

    static boolean dfs(int i, boolean[] visited, HashMap<Integer, List<Integer>> adj, Stack<Integer> st,boolean[] path) {
        visited[i] = true;
        path[i]=true;
        for (int it : adj.get(i)) {
            if (!visited[it] && dfs(it, visited, adj, st,path)) {
                return true;
            }
            else if(path[it]){
                return true;
            }
        }
        st.push(i);
        path[i]=false;
        return false;
    }
}
