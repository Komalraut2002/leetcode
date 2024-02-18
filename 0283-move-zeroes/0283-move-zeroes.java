class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count++;
            }
        }
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
            nums[j++]=nums[i];
            }
        }
        for(int i=n-count;i<n;i++){
            nums[i]=0;
        }
        
    }
}