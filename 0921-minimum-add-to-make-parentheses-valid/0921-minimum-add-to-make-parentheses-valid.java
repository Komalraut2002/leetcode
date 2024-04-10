class Solution {
    public int minAddToMakeValid(String s) {
        int n =s.length();
        int i=n-1;
        int count=0;
        int right=0;
        int left=0;
        while(i>=0){
             char curr=s.charAt(i);
             if(curr==')'){
                right++;
             }
             else if (curr=='(' && right!=0){
                  right--;
             }
             else{
                left++;
             }
             i--;
        }
        return (right+left);
    }
}