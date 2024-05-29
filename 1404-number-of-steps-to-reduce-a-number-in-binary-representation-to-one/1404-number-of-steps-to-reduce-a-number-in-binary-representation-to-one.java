import java.math.BigInteger;
class Solution {
    public int numSteps(String s) {
        int n=s.length();
        int count=0;
        BigInteger dec = new BigInteger(s, 2);
        while (!dec.equals(BigInteger.ONE)) {
            if (dec.mod(BigInteger.TWO).equals(BigInteger.ZERO)) { 
                dec = dec.divide(BigInteger.TWO);
            } else {  
                dec = dec.add(BigInteger.ONE);
            }
            count++;
        }
        return count;
    }
}