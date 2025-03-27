package graphs;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class haspath {
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
    public static boolean haspaths(ArrayList<edge> []graph,int src,int dest,boolean vis[]){
        if(src==dest ) return true;
        vis[src]= true;
        for(int  i=0;i<graph[src].size();i++){
            edge e = graph[src].get(i);
            if(!vis[e.dest] && haspaths(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<edge> [] graph = new ArrayList[v];
        creategraph(graph);
        System.out.println(haspaths(graph, 0, 4, new boolean[v]));
    }
}

