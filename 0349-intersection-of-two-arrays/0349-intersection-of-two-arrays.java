class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[]temp=new int[1001];
        int count=0;
        for(int it:nums1){
            temp[it]=1;
        }
        for(int it:nums2){
            if(temp[it]==1){
                temp[it]=2;
                count++;
            }
        }
        int [] ans=new int[count];
        int j=0;
        for(int i:nums2){
            if(temp[i]==2){
                temp[i]=1;
                ans[j]=i;
                j++;
            }
        }
        return ans;
    }
}