class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 0;
        int j = 0;
        int n = arr.length;
        int count = 0;

        while (j < n) {
            if (arr[j] % 2 != 0) {  
                count++;
                if (count == 3) { 
                    return true;
                }
                j++;
            } else {  
                count = 0;  
                j++;
                i = j; 
            }
        }

        return false; 
    }
}
