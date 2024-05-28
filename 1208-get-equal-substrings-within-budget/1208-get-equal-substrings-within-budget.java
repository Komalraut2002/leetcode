class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int i=0;
        int j=0;
        int cost=0;
        int maxLength = 0;
        while(j<n){
            char a=s.charAt(j);
            char b=t.charAt(j);
            cost+=Math.abs(a-b);
            while(cost>maxCost){
               cost-=Math.abs(s.charAt(i)-t.charAt(i));
               i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}