// Given an adjacency list of a graph adj of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        Queue<Integer>q=new LinkedList<>();
        int color[]=new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
            q.add(i);
           color[i]=0;
        while(!q.isEmpty()){
            int d=q.remove();
            for(int j=0;j<adj.get(d).size();j++){
                int a=adj.get(d).get(j);
                if(color[a]==-1){
                    color[a]=(color[d]+1)%2;
                    q.add(a);
                }else{
                    if(color[a]==color[d]){
                        return false;
                    }
                    
                }
            }
            
        }
        }
        }
        
        return true;
    }
}
