class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ( grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    dfs(grid, i, j, visited);
                }
            }
        }

        return cnt;
    }

    static void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        
        
       if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
             dfs(grid, i+1, j, visited);
             dfs(grid, i-1, j, visited);
             dfs(grid, i, j+1, visited);
             dfs(grid, i, j-1, visited);
    }
}
