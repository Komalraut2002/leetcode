class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        if(image[sr][sc]==color){
            return image;
        }
        int old=image[sr][sc];
        if(image[sr][sc]!=color){
            dfs(image,sr,sc,color,old);
        }

        return image;
    }

    static void dfs(int[][]image,int i,int j,int color,int old){
        int m=image.length;
        int n=image[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != old) {
            return;
        }
        
        image[i][j]=color;
        dfs(image, i + 1, j,color,old);
        dfs(image, i - 1, j,color,old);
        dfs(image, i, j + 1,color,old);
        dfs(image, i, j - 1,color,old);
    }
}