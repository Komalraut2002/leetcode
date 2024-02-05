class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        // boolean[][]visited=new boolean[m][n];
        //first row
        for(int j=0;j<n;j++){
           if(board[0][j]=='O' ){
               dfs(0,j,board);
           }
        }
        //last row
        for(int j=0;j<n;j++){
           if(board[m-1][j]=='O' ){
               dfs(m-1,j,board);
           }
        }
        //first column
        for(int i=0;i<m;i++){
           if(board[i][0]=='O'){
               dfs(i,0,board);
           }
        }
        //last column
        for(int i=0;i<m;i++){
           if(board[i][n-1]=='O'){
               dfs(i,n-1,board);
           }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    static void dfs(int start,int last,char[][]board){
        int m = board.length;
        int n = board[0].length;
        // visited[start][last]=true;
       

        if (start < 0 || start >= m || last < 0 || last >= n || board[start][last] != 'O' ) {
            return;
        }
         board[start][last] = 'V';

         dfs(start+1,last,board);
         dfs(start-1,last,board);
         dfs(start,last+1,board);
         dfs(start,last-1,board);
    }
}