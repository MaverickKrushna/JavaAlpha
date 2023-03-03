package com.krushnaDSA;

import java.util.ArrayList;

public class Ap_39TopologiclaSorting {
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



        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));


        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));


    }
    // Topological Sorting



    public static void main(String[] args) {
        int V=6 ;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        

    }
}
