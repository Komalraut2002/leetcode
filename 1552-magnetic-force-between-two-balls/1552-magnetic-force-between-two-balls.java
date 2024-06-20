class Solution {
    public boolean check(int[]position,int mid,int k){
        int n=position.length;
        int count=1;
        int last_pos=position[0];
        for(int i=0;i<n;i++){
            if(position[i]-last_pos>=mid){
                count++;
                last_pos=position[i];
            }
        }
        if(count>=k){
            return true;
        }
        else{
            return false;
        }
    }
    public int maxDistance(int[] position, int m) {
        int n=position.length;
        Arrays.sort(position);
        int start=0;
        int end=position[n-1]-position[0];
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(check(position,mid,m)==true){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
}