class Solution {
    public int orangesRotting(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       int freshcnt=0;
       int time=0;
       Queue <pair> q=new LinkedList<>();
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(grid[i][j]==2){
                   q.add(new pair(i,j));
               }
               if(grid[i][j]==1){
                   freshcnt++;
               }
           }
       }
       if(freshcnt==0){
           return 0;
       } 
       while(!q.isEmpty()){
           int size=q.size();
           int curr=0;
           while(size!=0){
           pair p=q.poll();
           int x1=p.first;
           int y1=p.second;
           int[] delx = {1, -1, 0, 0};
           int[] dely = {0, 0, -1, 1};

           for(int i=0;i<4;i++){
               int x=x1+delx[i];
               int y=y1+dely[i];
               if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                   curr++;
                   grid[x][y]=2;
                   q.add(new pair(x,y));
               }
           }
           size--;
        }
        if(curr!=0){
            time++;
        }
    }
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(grid[i][j]==1){
                   return -1;
               }
           }
       }
       return time;
    }
}
class pair {
    int first;
    int second; 
    public pair(int first, int second) {
        this.first = first; 
        this.second = second; 
    }
}