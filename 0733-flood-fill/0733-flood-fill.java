class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int old=image[sr][sc];
        if(old==color){
            return image;
        }
        dfs(image,sr,sc,color,old);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color,int old){
        int m=image.length;
        int n=image[0].length;
        image[sr][sc]=color;
        int[] x={-1,1,0,0};
        int[] y={0,0,-1,1};
        for(int i=0;i<4;i++){
            int newX=x[i]+sr;
            int newY=y[i]+sc;
            if(newX>=0 && newX<m && newY>=0 && newY<n && image[newX][newY]==old){
                dfs(image,newX,newY,color,old);
            }
        }
    }
}