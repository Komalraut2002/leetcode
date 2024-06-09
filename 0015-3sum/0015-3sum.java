class Solution {
    List<List<Integer>>ans=new ArrayList<>();

    public void twoSum(int[]nums,int target,int i,int j){
            while(i<j){
                if(nums[i]+nums[j]>target){
                    j--;
                }
                else if(nums[i]+nums[j]<target){
                    i++;
                }
                else{
                    while(i<j && nums[i]==nums[i+1])i++;
                    while(i<j && nums[j]==nums[j-1])j--;
                    ans.add(Arrays.asList(-target, nums[i], nums[j]));
                    i++;
                    j--;
                }
            }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        //fix the one element : n1
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
               continue;
            }
            int target=-(nums[i]);
            twoSum(nums,target,i+1,n-1);
        }
        return ans;
    }
}