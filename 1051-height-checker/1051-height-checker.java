class Solution {
    public int heightChecker(int[] heights) {
       int n=heights.length;
       int count=0;
       int j=0;
       int [] arr=new int[n];
       for(int it:heights){
        arr[j++]=it;
       }
       Arrays.sort(arr);
       for(int i=0;i<n;i++){
        if(heights[i]!=arr[i]){
            count++;
        }
       }
       return count;
    }
}