class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int m=flights.length;
        int p=flights[0].length;
        int [] dist=new int [n];
        Arrays.fill(dist,(int)1e9);
        HashMap<Integer,List<pair>> adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];

            adj.get(u).add(new pair(v,w));
        }
        Queue<tuple> q = new LinkedList<>(); 
        
        q.add(new tuple(0, src, 0));
        dist[src]=0;
        while(!q.isEmpty()) {
            tuple it = q.peek(); 
            q.remove(); 
            int stops = it.first; 
            int node = it.second; 
            int cost = it.third; 
            
            
            if(stops > k) continue; 
            for(pair iter: adj.get(node)) {
                int adjNode = iter.first; 
                int edW = iter.second; 
                
                
                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW; 
                    q.add(new tuple(stops + 1, adjNode, cost + edW)); 
                }
            }
        }

        
        if(dist[dst]==(int)1e9)return -1;
        return dist[dst];
    }
}
class pair{
    int first;
    int second;
    public pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class tuple{
    int first;
    int second;
    int third;
    public tuple(int first,int second , int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}