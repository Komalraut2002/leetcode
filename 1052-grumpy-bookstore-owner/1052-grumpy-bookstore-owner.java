class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int zeroSum = 0; 
        int maxGain = 0; 
        int currentGain = 0; 
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                zeroSum += customers[i];
            }
            if (i < minutes && grumpy[i] == 1) {
                currentGain += customers[i];
            }
        }

        maxGain = currentGain; 

        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                currentGain += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currentGain -= customers[i - minutes];
            }
            maxGain = Math.max(maxGain, currentGain);
        }
        return zeroSum + maxGain;
    }
}
