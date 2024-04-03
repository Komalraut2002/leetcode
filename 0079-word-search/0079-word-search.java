class Solution {
    static boolean dfs(boolean [][] visited,char[][]board,String word,int i,int j,int k)
    {   int len=word.length();
        int m=board.length;
        int n=board[0].length;
        int [] x={0,0,-1,1};
        int [] y={-1,1,0,0};
        if(k==len){
            return true;
        }
         if(i>=m || i<0 || j<0 || j>=n || board[i][j]!=word.charAt(k) || visited[i][j]){
            return false;
         }
         visited[i][j]=true;

        for(int it=0;it<4;it++){
            int delx=x[it]+i;
            int dely=y[it]+j;
        if(dfs(visited,board,word,delx,dely,k+1)){
               return true;
               }
            }
        visited[i][j]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int len=word.length();
        int m=board.length;
        int n=board[0].length;
        boolean [][]visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                  if(dfs(visited,board,word,i,j,0)){
                    return true;
                  }
                }
            }
        }
        return false;
    }
}