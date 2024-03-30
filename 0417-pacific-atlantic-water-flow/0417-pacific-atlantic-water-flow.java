class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
     List<List<Integer>> ans=new ArrayList<>();
     int m=heights.length;
     int n=heights[0].length;

     boolean [][] pacific=new boolean[m][n];
     boolean [][] atlantic=new boolean[m][n];
     for(int i=0;i<m;i++){
        dfs(i,0,heights,pacific,Integer.MIN_VALUE);
        dfs(i,n-1,heights,atlantic,Integer.MIN_VALUE);
     }
     for(int j=0;j<n;j++){
        dfs(0,j,heights,pacific,Integer.MIN_VALUE);
        dfs(m-1,j,heights,atlantic,Integer.MIN_VALUE);
     }
     for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            List<Integer> temp=new ArrayList<>();
            if(pacific[i][j] && atlantic[i][j]){
               temp.add(i);
               temp.add(j);
               ans.add(temp);
            }
        }
     }
     return ans;   
    }
    static void dfs(int i,int j,int[][]heights, boolean[][]visited,int prev){
        int m=heights.length;
        int n=heights[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || prev > heights[i][j]) {
            return;
        }
        visited[i][j]=true;

         int[]x={0,0,-1,1};
         int[]y={1,-1,0,0};
         for(int id=0;id<4;id++){
            int delx=x[id]+i;
            int dely=y[id]+j;
            dfs(delx,dely,heights,visited,heights[i][j]);
         }
    }
}