class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int m=image.length;
        int n=image[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int temp=image[i][j]==0?1:0;
                image[i][j]=image[i][n-j-1]==0?1:0;
                image[i][n-j-1]=temp;
            }
        }
        if(n%2==1){
            for(int i=0;i<m;i++){
                image[i][(n/2)]=image[i][(n/2)]==0?1:0;
            }
        }
        return image;
    }
}