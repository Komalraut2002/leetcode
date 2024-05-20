class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
    public int helper(int[]nums,int i, int currentXOR){
        int n=nums.length;
        if(i>=n){
            return currentXOR ;
        }
        int take=helper(nums,i+1,currentXOR^nums[i]);
        int not=helper(nums,i+1,currentXOR);
        return (take+not);
    }
}