class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            boolean flag=check(matrix[i],target);
            if(flag==true){
                return true;
            }
        }
        return false;
    }
    static boolean check(int[]row,int target){
        int n=row.length;
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(row[mid]==target){
                return true;
            }
            else if(target>row[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return false;
    }
}