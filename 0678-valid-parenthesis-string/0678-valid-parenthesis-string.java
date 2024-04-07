class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int lopenMin = 0, lopenMax = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                lopenMin++;
                lopenMax++;
            } else if (s.charAt(i) == ')') {
                lopenMax--;
                lopenMin--;
            } else {
                lopenMin--;
                lopenMax++;
            }
            if (lopenMax < 0) {
                return false; // )))))))))))))
            }
            if (lopenMin < 0) {
                lopenMin = 0; // ))(((((
            }
        }
        return lopenMin == 0;
    }
}