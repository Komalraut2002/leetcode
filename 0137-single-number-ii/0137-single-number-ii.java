class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int ones=0;
        int twos=0;
        for(int i:nums){
            ones=(ones^i)&(~twos);
            twos=(twos^i)&(~ones);
        }
        return ones;
    }
}