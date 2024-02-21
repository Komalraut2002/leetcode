class Solution {
    public void dfs(int start,int last,char[][]board){
        int m=board.length;
        int n=board[0].length;
        int []x={-1,1,0,0};
        int []y={0,0,-1,1};
        if (start < 0 || start >= m || last < 0 || last >= n || board[start][last] != 'O') {
            return;
        }
        board[start][last] = 'A';
        for(int i=0;i<4;i++){
        int X=x[i]+start;
        int Y=y[i]+last;
        dfs(X,Y,board);
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        //first row
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
               dfs(0,j,board);
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
        //last row
        for(int j=0;j<n;j++){
            if(board[m-1][j]=='O'){
               dfs(m-1,j,board);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='A'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}