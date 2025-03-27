package graphs;

import java.util.*;
import java.util.Queue;

public class bfs {
    static class edge{
        int src;
        int dest;
        int wt;
        public edge(int s,int d,int w){
            this.src= s;
            this.dest = d;
            this.wt = w ;       
        }
    }

    static void creategraph(ArrayList<edge>[] graph){
        for(int  i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        } 

        graph[0].add(new edge(0, 1, 5));

        //1--vertex
        graph[1].add(new edge(1, 0, 5));
        
         graph[1].add(new edge(1, 2, 1)); 
         graph[1].add(new edge(1, 3, 3));

         //vertex 2
         graph[2].add(new edge(2, 1, 1));
         graph[2].add(new edge(2, 3, 1));
         graph[2].add(new edge(2, 4, 4));

         //veryex 3
         graph[3].add(new edge(3, 2, 1));
         graph[3].add(new edge(3, 1, 3));

         //vertex 4
         graph[4].add(new edge(4, 2, 4));
    }
    public static void bfs(ArrayList<edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean vis [] = new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i =0;i<graph[curr].size();i++){
                    edge e =graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v= 5;
        ArrayList<edge>[] graph = new ArrayList[v];
        creategraph(graph);
        bfs(graph);
    }
    
}
