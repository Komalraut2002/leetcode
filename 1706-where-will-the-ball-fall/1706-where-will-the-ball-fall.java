class Solution {
    public int[] findBall(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            int row=0;
            int col=i;
            boolean flag=false;
            while(row<m && col<n){
                if(grid[row][col]==1){
                   if(col==n-1 || grid[row][col+1]==-1){
                    flag=true;
                    break;
                   }
                   col++;
                }
                else{
                    if(col==0 || grid[row][col-1]==1){
                    flag=true;
                    break;
                   }
                   col--;
                }
                row++;
            }
            if(flag==true){
                ans[i]=-1;
            }
            else{
                ans[i]=col;
            }
        }
        return ans;
    }
}