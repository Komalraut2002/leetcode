class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        if(image[sr][sc]==color){
            return image;
        }
        int old=image[sr][sc];
        boolean[][] visited=new boolean[m][n];
        if(image[sr][sc]!=color && !visited[sr][sc]){
            dfs(visited,image,sr,sc,color,old);
        }

        return image;
    }

    static void dfs(boolean[][]visited,int[][]image,int i,int j,int color,int old){
        int m=image.length;
        int n=image[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != old || visited[i][j]) {
            return;
        }
        visited[i][j]=true;
        image[i][j]=color;
        dfs(visited,image, i + 1, j,color,old);
        dfs(visited,image, i - 1, j,color,old);
        dfs(visited,image, i, j + 1,color,old);
        dfs(visited,image, i, j - 1,color,old);
    }
}