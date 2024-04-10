class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
    int n=deck.length;
    int [] ans=new int[n];
    Arrays.sort(deck);
    if(n<=2){
        return deck;
    }
    Queue<Integer> q=new LinkedList<>();
    q.add(deck[n-1]);
    q.add(deck[n-2]);
    for(int i=n-3;i>=0;i--){
        int curr=q.remove();
        q.add(curr);
        q.add(deck[i]);
    } 
    int i=n-1; 
    while(!q.isEmpty()){
        ans[i--]=q.remove();
    }  
    return ans;
    }
}