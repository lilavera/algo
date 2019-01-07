
package algoritm2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Algoritm2 {
    
    //dfs dla zwyklego grafa
     private static void SimpleDFS(int [][] dislike, boolean[] visited, Stack<Integer> stack, int v) {
       
        visited[v] = true;

        for (Integer adjacentv : getAdjacentVertices(dislike, v)) {
            if (!visited[adjacentv]) {
                SimpleDFS(dislike, visited, stack, adjacentv);
            }
        }

       
        stack.push(v);
    }

     
     //dfs dla odwroconego grafa
    private static void DFSForReverseGraph(int [][] dislike, boolean[] visited, List<Integer> list, int v) {
        visited[v] = true;
        list.add(v);

        for (Integer adjacentv : getAdjacentVertices(dislike, v)) {
            if (!visited[adjacentv]) {
                DFSForReverseGraph(dislike, visited, list, adjacentv);
            }
        }

    }
   public static List<List<Integer>> KosarajuAlgoritm(int[][] dislike) {
        boolean[] visited = new boolean[dislike.length];
      Stack<Integer> stack = new Stack<>();
      for (int v = 0; v < dislike.length; v++) {
            if (!visited[v]) {
                SimpleDFS(dislike, visited, stack, v);
            }
        }
        int[][] reverseGraph = getReverseGraph(dislike);
        List<List<Integer>> components = new ArrayList<>();
        visited = new boolean[dislike.length];
        //wypelnimy stos
        while (!stack.isEmpty()) {
            int v = stack.pop();
            //jezeli wierzcholek nie jest odwiezony wywolujemy DFS
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                DFSForReverseGraph(reverseGraph, visited, component, v);

                components.add(component);
            }
        }

        return components;
    }

   


    private static List<Integer> getAdjacentVertices(int [][] dislike, int source) {
        List<Integer> adjacentVertices = new ArrayList<>();

        for (int v = 0; v < dislike.length; v++) {
            if (dislike [source][v] == 1) {
                adjacentVertices.add(v);
            }
        }

        return adjacentVertices;
    }

    private static int[][] getReverseGraph(int[][] dislike) {
        int[][] reverseGraph = new int[dislike.length][dislike.length];

        for (int row = 0; row < dislike.length; row++) {
            for (int col = 0; col < dislike[row].length; col++) {

                if (dislike[row][col] == 1) {
                    reverseGraph[col][row] = 1;
                }
            }
        }

        return reverseGraph;
    }

   
}


