import algorithms.*;
import java.util.ArrayList;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test2.in");
        Out.compareTo("public/test2.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
        
        // Uncomment this line if you want to read from a file
        In.close();
    }

    public static void testCase() {
        // Input using In.java class
        int n = In.readInt();
        int s = In.readInt();
        int d = In.readInt();
        
        ArrayList<Integer>[] sunEdges = new ArrayList[n];
        ArrayList<Integer>[] shadowEdges = new ArrayList[n];
        
        boolean[][] isSun = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
          sunEdges[i] = new ArrayList<>();
          shadowEdges[i] = new ArrayList<>();
        }
        
        int[][] capacity = new int[n][n];
        int[][] flow = new int[n][n];
        int[][] diff = new int[n][n];
        
        
        for(int i = 0; i < s; i++){
          int u = In.readInt();
          int v = In.readInt();
          
          isSun[u][v] = true;
          isSun[v][u] = true;
          sunEdges[u].add(v);
          sunEdges[v].add(u);
          capacity[u][v] = 1;
          flow[u][v] = 0;
          diff[u][v] = 1;
          capacity[v][u] = 1;
          flow[v][u] = 0;
          diff[v][u] = 1;
        }
        
        for(int i = 0; i < d; i++){
          int u = In.readInt();
          int v = In.readInt();
          shadowEdges[u].add(v);
          shadowEdges[v].add(u);
          capacity[u][v] = 1;
          flow[u][v] = 0;
          diff[u][v] = 1;
          capacity[v][u] = 1;
          flow[v][u] = 0;
          diff[v][u] = 1;
        }
        
        int[] parent = new int[n];
        int flowValue = 0;
        boolean[][] cut = new boolean[n][n];
        
        int sunFlow = maxFlow1(diff, sunEdges, parent, 0, n-1, n);
        cut(cut, sunEdges, 0, diff);
        int shadowFlow = maxFlow2(diff, shadowEdges, parent, 0, n-1, n, sunEdges, cut, isSun);
        
        Out.println(sunFlow+" "+ shadowFlow);
        
        
    }
    
    private static boolean bfs(int[][] diff, ArrayList<Integer>[] edges, int[] parent, int s, int t){
      ArrayList<Integer> queue = new ArrayList<>();
      boolean[] marked = new boolean[parent.length];
      queue.add(s);
      marked[s] = true;
      
      while(queue.size() != 0){
        int current = queue.remove(0);
        for(int i = 0; i < edges[current].size(); i++){
          int neighbor = edges[current].get(i);
          if(!marked[neighbor] && diff[current][neighbor] >0){
            parent[neighbor] = current;
            marked[neighbor] = true;
            queue.add(neighbor);
            if(neighbor == t){
              return true;
            }
          }
        }
      }
      return false;
    }
    
    private static boolean bfs2(int[][] diff, ArrayList<Integer>[] edges, int[] parent, int s, int t, ArrayList<Integer>[] sunEdges, boolean[][] cut){
      ArrayList<Integer> queue = new ArrayList<>();
      boolean[] marked = new boolean[parent.length];
      queue.add(s);
      marked[s] = true;
      
      while(queue.size() != 0){
        int current = queue.remove(0);
        for(int i = 0; i < edges[current].size(); i++){
          int neighbor = edges[current].get(i);
          if(!marked[neighbor] && diff[current][neighbor] >0){
            parent[neighbor] = current;
            marked[neighbor] = true;
            queue.add(neighbor);
            if(neighbor == t){
              return true;
            }
          }
        }
        for(int i = 0; i < sunEdges[current].size(); i++){
          int neighbor = sunEdges[current].get(i);
          if(!marked[neighbor] && diff[current][neighbor] >0 && !cut[current][neighbor]){
            parent[neighbor] = current;
            marked[neighbor] = true;
            queue.add(neighbor);
            if(neighbor == t){
              return true;
            }
          }
        }
        
      }
      return false;
    }
    
    private static int maxFlow1(int[][] diff, ArrayList<Integer>[] edges, int[] parent, int s, int t, int n){
        
        int flowValue = 0;
        
        while(bfs(diff, edges, parent, 0, n-1)){
          
          int v = n-1;
          int u = parent[n-1];
          int min = Integer.MAX_VALUE;
          while(v != 0){
            min = Math.min(min, diff[u][v]);
            v = u;
            u = parent[v];
          }
          
          v = n-1;
          u = parent[v];
          while(v != 0){
            diff[u][v] -= min;
            
            int a = diff[v][u] + min;
            diff[v][u] += min;   //Math.min(capacity[v][u], a);
            v = u;
            u = parent[v];
          }
          
          flowValue += min;
        }
        return flowValue;
    }
    
    private static int maxFlow2(int[][] diff, ArrayList<Integer>[] edges, int[] parent, int s, int t, int n, ArrayList<Integer>[] sunEdges, boolean[][] cut, boolean[][] isSun){
        
        int flowValue = 0;
        
        while(bfs2(diff, edges, parent, 0, n-1, sunEdges, cut)){
          
          int v = n-1;
          int u = parent[n-1];
          int min = Integer.MAX_VALUE;
          while(v != 0){
            if(!isSun[u][v]){
               min = Math.min(min, diff[u][v]);
            }
            v = u;
            u = parent[v];
          }
          
          v = n-1;
          u = parent[v];
          while(v != 0){
            if(!isSun[u][v]){
              diff[u][v] -= min;
              int a = diff[v][u] + min;
              diff[v][u] += min;   //Math.min(capacity[v][u], a);
            }
            
            v = u;
            u = parent[v];
          }
          
          flowValue += min;
        }
        return flowValue;
    }
    
    private static void cut(boolean[][] cut, ArrayList<Integer>[] edges, int s, int[][] diff){
      ArrayList<Integer> queue = new ArrayList<>();
      boolean[] marked = new boolean[edges.length];
      queue.add(s);
      marked[s] = true;
      
      while(queue.size() != 0){
        int current = queue.remove(0);
        for(int i = 0; i < edges[current].size(); i++){
          int neighbor = edges[current].get(i);
          if(!marked[neighbor]){
            if(diff[current][neighbor] == 0){
              //cut[current][neighbor] = true;
            }
            else{
              marked[neighbor] = true;
              queue.add(neighbor);
            }
          }
        }
      }
      for(int u = 0; u < edges.length; u++){
        if(marked[u]){
          for(int v: edges[u]){
            if(!marked[v]){
              cut[u][v] = true;
              cut[v][u] = true;
            }
          }
        }
      }
    }
}
