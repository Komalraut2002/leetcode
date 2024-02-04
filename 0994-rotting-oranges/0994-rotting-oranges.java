class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        Queue<pair> q =new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int cnt=0;
        int time=0;
        while(!q.isEmpty()){
            pair p=q.poll();
            int x=p.first;
            int y=p.second;
            int t=p.tm;
            time=Math.max(t,time);
            int [] delx={-1,1,0,0};
            int [] dely={0,0,1,-1};
            for(int i=0;i<4;i++){
                int nrow=x+delx[i];
                int ncol=y+dely[i];
                if(nrow<m && ncol<n && nrow>=0 && ncol>=0 && grid[nrow][ncol]==1){
                    cnt++;
                    grid[nrow][ncol]=2;
                    q.add(new pair(nrow,ncol,t+1));
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        if(cnt!=fresh){
            return -1;
        }
        return time;
    }
}
class pair{
    int first;
    int second;
    int tm;
    public pair(int first,int second,int tm){
        this.first=first;
        this.second=second;
        this.tm=tm;
    }
}