import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    static void dfs(int i, boolean[] visited, HashMap<Integer, ArrayList<Integer>> adj, Stack<Integer> st) {
        visited[i] = true;
        for (int neighbor : adj.get(i)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, st);
            }
        }
        st.push(i);
    }

      public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj, st);
            }
        }

    Map<Integer, Integer> pos = new HashMap<>();
     
    int ind = 0;
     
    while (!st.isEmpty()) 
    {
        pos.put(st.peek(), ind);
        ind += 1;
        st.pop();
    }
 
    for(int i = 0; i < numCourses; i++) 
    {
        for(Integer it : adj.get(i))
        {
            if (pos.get(i) >= pos.get(it))
            {
                return false;
            }
        }
    }
 
    return true;
  }

}
