class Solution {
    public String makeGood(String s) {
        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i < ans.length() - 1; ) {
            char currentChar = ans.charAt(i);
            char nextChar = ans.charAt(i + 1);
            if (Character.toLowerCase(currentChar) == Character.toLowerCase(nextChar) && currentChar != nextChar) {
                ans.delete(i, i + 2);
                i = Math.max(i - 1, 0);
            } else {
                i++;
            }
        }
        return ans.toString();
    }
}
