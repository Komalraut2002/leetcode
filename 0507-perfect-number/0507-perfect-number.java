class Solution {
    public boolean checkPerfectNumber(int num) {
        int i=1;
        long count=0;
        while(i<num){
            if(num%i==0){
                count+=i;
            }                    
            i++;
        }
        return count==num;
    }
}
