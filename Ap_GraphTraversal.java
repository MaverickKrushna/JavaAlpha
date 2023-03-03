package com.krushnaDSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ap_GraphTraversal {
    static class Edge{
        int src ;
        int dest ;
        Edge(int s , int d){
            this.src = s ;
            this.dest = d ;
        }
    }



    public  static void createGraph(ArrayList<Edge> graph[]){
        for (int i =0 ; i< graph.length ; i++){
            graph[i]=  new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));


        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    static  void bfs (ArrayList<Edge>[] graph, int V){

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[V];
        q.add(0);
        while (!q.isEmpty()){
            int curr = q.remove();
            if (!visit[curr]){
                System.out.print( curr + " ");
                visit[curr]= true ;
                for ( int i=0 ;i<graph[curr].size() ;i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }
 // bfs with not connected edges ---:::::
 static  void bfsNC (ArrayList<Edge> graph[] , int V , boolean visit[] , int start){

     Queue<Integer> q = new LinkedList<>();

     q.add(start);
     while (!q.isEmpty()){
         int curr = q.remove();
         if (visit[curr]== false){
             System.out.print( curr + " ");
             visit[curr]= true ;
             for ( int i=0 ;i<graph[curr].size() ;i++){
                 Edge e = graph[curr].get(i);
                 q.add(e.dest);
             }
         }
     }

 }
    static void bfsnontConnected(ArrayList<Edge> graph[] , int V){
        boolean visit [ ]= new boolean[V];
         for (int i=0 ; i < V ; i++){
             if (visit[i]== false){
                 bfsNC(graph , V,visit , i);
             }
         }
        System.out.println();

    }


    // DFS
    public static  void dfs(ArrayList<Edge> graph[] , int V, boolean visit [ ] , int start){
        Stack<Integer> s = new Stack<>();
        s.push(start);
        while (!s.isEmpty()){
            int curr = s.pop();
            if (visit[curr]== false){
                System.out.print(curr +" ");
                visit[curr]= true ;
                for ( int i=0 ;i<graph[curr].size() ;i++){
                    Edge e = graph[curr].get(i);
                    s.push(e.dest);
                }
            }
        }

    }
    // dsf not connected
    public static  void dfsnotConnected(ArrayList<Edge> graph[] , int V){
        boolean visit[] = new boolean[V];
        for (int i=0 ; i< V;i++){
            dfs(graph , V , visit , i);
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int V=7 ;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
//        bfs(graph , V);
        bfsnontConnected(graph ,V);
        dfsnotConnected(graph , V);





    }
}
