class Solution {
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxi=0;
        boolean [][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    int gold=helper(i,j,grid,visited);
                    maxi=Math.max(gold,maxi);
                }
            }
        }
        return maxi;
    }
    public static int helper(int i,int j,int[][]grid,boolean[][]visited){
        int m=grid.length;
        int n=grid[0].length;
        if(i>=m || i<0 || j<0 || j>=n || visited[i][j] || grid[i][j]==0){
            return 0;
        }
        visited[i][j] = true;
                int down = helper( i+1, j,grid, visited);
                int up = helper(i-1, j,grid, visited);
                int right = helper( i, j+1, grid,visited);
                int left = helper( i, j-1,grid, visited);
        visited[i][j] = false;
        return  Math.max(down,Math.max(left,Math.max(right,up))) + grid[i][j];
    }
}