class Solution {
    public int countPrimes(int n) {
       int count=0;
       if(n<=2){
        return 0;
       } 
      boolean [] arr=new boolean [n];
       for(int i=2;i<=(int)Math.sqrt(n);i++){
          if(arr[i]==false){
            for(int j=i*i;j<n;j+=i){
                arr[j]=true;
            }
          }
       }
       for(int i=2;i<n;i++){
        if(arr[i]==false){
            count++;
        }
       }
       return count;
    }
}