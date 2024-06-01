class Solution {
    public int scoreOfString(String s) {
        int count=0;
        int n=s.length();
        for(int i=1;i<n;i++){
            count+=Math.abs(s.charAt(i)-s.charAt(i-1));
        }
        return count;
    }
}