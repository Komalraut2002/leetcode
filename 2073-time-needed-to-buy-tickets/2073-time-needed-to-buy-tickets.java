class Solution {
    public int timeRequiredToBuy(int[] t, int k) {
        int n=t.length;
        int maxi=t[k];
        int count=0;
        for(int i=0;i<n;i++){
           if(t[i]>=maxi){
            if(i>k){
            count+=maxi-1;
            }
            else{
               count+=maxi;
            }
           }
           else{
            count+=t[i];
           }
         }
        return count;
    }
}