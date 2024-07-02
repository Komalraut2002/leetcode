class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);  
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0, j = 0, k = 0;     
        ArrayList<Integer> temp=new ArrayList<>();
        while( i < l1 && j < l2){
            if(nums1[i] < nums2[j])
            {
                i++;
            }
            else if(nums1[i] > nums2[j])
            {
                j++;
            }
            else{
                temp.add(nums1[i]);
                i++;
                j++;
            }

        }
        int[]ans=new int[temp.size()];
        int g=0;
        for(int it:temp){
            ans[g++]=it;
        }
        return ans;
    }
}