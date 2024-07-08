class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=1;i<=n;i++){
            temp.add(i);
        }
        int i=0;
        while(temp.size()>1){
             int next=(i+k-1)%temp.size();
             temp.remove(next);
             i=next;
        }
        return temp.get(0);
    }
}