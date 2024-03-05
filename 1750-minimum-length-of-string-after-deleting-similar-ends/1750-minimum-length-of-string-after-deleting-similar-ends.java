class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        int i=0;
        int j=n-1;
        while(i<j && s.charAt(i)==s.charAt(j)){
            Character curr=s.charAt(i);
                while(i<=j && curr==s.charAt(i))i++;
                while(i<=j && curr==s.charAt(j))j--;
        }
        return i>j?0:j+1-i;
    }
}

