
package algoritm2;

import static algoritm2.Algoritm2.KosarajuAlgoritm;
import java.util.List;


public class Main {
    
     public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
        };

        List<List<Integer>> components = KosarajuAlgoritm(graph);

        System.out.println("Silne spojne skladowe w grafie to : ");

        for (List<Integer> component : components) {
            System.out.println(component);
        }

    }
}
    

