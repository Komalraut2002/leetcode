class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=n-1;
        int top=0;
        int bottom=m-1;
        int depth=0;
        while(left<=right && top<=bottom){
            if(depth==0){
                for(int i=left;i<=right;i++){
                    ans.add(matrix[top][i]);
                }
               depth++;
               top++;
            }
            else if(depth==1){
                for(int i=top;i<=bottom;i++){
                    ans.add(matrix[i][right]);
                }
                depth++;
                right--;
            }
            else if(depth==2){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                depth++;
                bottom--;
            }
            else if(depth==3){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                depth=0;
                left++;
            }
        }
        return ans;
    }
}