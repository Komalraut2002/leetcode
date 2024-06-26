class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num=Math.abs(nums[i]);
            if(nums[num-1]<0){
                ans.add(num);
            }
            nums[num-1]*=-1;
        }
        return ans;
    }
}