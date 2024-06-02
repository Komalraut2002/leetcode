class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        int i=0;
        int j=n-1;
        while(i<j){
             char temp=s[j];
             s[j]=s[i];
             s[i]=temp;
             i++;
             j--;
        }
    }
}