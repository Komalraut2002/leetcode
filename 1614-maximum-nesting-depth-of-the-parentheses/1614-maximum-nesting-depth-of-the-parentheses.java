class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int count=0;
        int maxi=0;
        for(char i:s.toCharArray()){
            if(i=='('){
                count++;
            }
            else if(i==')'){
                count--;
            }
            maxi=Math.max(maxi,count);
        }
        return maxi;
    }
}