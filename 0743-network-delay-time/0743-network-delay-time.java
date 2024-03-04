class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int m=times.length;
        HashMap<Integer,ArrayList<pair>> adj=new HashMap<>();
        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];

            adj.get(u).add(new pair(v,w));
        }
        PriorityQueue<pair> q=new PriorityQueue<>((x,y)->(x.first-y.first));
        int [] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        q.add(new pair(0,k));
        while(!q.isEmpty()){
            pair top=q.poll();
            int dis=top.first;
            int node=top.second;
            for(pair it:adj.get(node)){
                int currNode=it.first;
                int currDist=it.second;
                if(currDist+dis<dist[currNode]){
                    dist[currNode]=currDist+dis;
                    q.add(new pair(currDist+dis,currNode));
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
              if(dist[i]==Integer.MAX_VALUE){
                  return -1;
              }
              else{
                  max=Math.max(max,dist[i]);
              }
        }
        return max;
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