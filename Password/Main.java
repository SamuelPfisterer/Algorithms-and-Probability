import algorithms.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        // In.open("public/test3.in");
        // Out.compareTo("public/test3.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
        
        // Uncomment this line if you want to read from a file
        // In.close();
    }

    public static void testCase() {
        // Input using In.java class
        int n = In.readInt();
        ArrayList<String> nodes = new ArrayList<>();
        ArrayList<String> papers = new ArrayList<>();
        HashMap<String, Integer> inDegree = new HashMap<>();
        HashMap<String, Integer> outDegree = new HashMap<>();
        HashMap<String, ArrayList<String>> edges = new HashMap<>();
        HashMap<String, Boolean> marked = new HashMap<>();
        
        
        for(int i = 0; i < n; i++){
          String currentPaper = In.readWord();
          papers.add(currentPaper);
        }
        
        for(int i = 0; i < papers.size(); i++){
          String currentPaper = papers.get(i);
          String start = currentPaper.substring(0,2);
          String end = currentPaper.substring(1, 3);
          
          
          if(!nodes.contains(start)){
            nodes.add(start);
            outDegree.put(start, 0);
            inDegree.put(start, 0);
          }
          outDegree.put(start, outDegree.get(start)+1);
          if(!nodes.contains(end)){
            nodes.add(end);
            inDegree.put(end, 0);
            outDegree.put(end,0);
          }
          inDegree.put(end, inDegree.get(end) +1);
        }
        
        for(String s: nodes){
          edges.put(s, new ArrayList<String>());
        }
        for(String s: papers){
          String from = s.substring(0,2);
          String to = s.substring(1,3);
          ArrayList<String> current = edges.get(from);
          current.add(to);
          current = edges.get(to);
          current.add(from);
        }
        
        for(String s: nodes){
          marked.put(s, false);
        }
        
        DFS(nodes.get(0), marked, edges);
        
        
        int counterMinus = 0;
        int counterPlus = 0;
        boolean truth = true;
        
        
        for(String node: nodes){
          if(!marked.get(node)){
            truth = false;
          }
        }
        
        
        
        
        for(String a: inDegree.keySet()){
          int in = inDegree.get(a);
          int out = outDegree.get(a);
          if(Math.abs(in-out) > 1){
            //System.out.println("to biig");
            truth = false;
          }
          
          if(in-out == -1){
            counterMinus++;
          }
          if(in - out == 1){
            counterPlus ++;
          }
        }
        if(counterMinus >1 || counterPlus >1){
          //System.out.println("too many counters");
          truth = false;
        }
        
        
        
        // Output using Out.java class
        if(truth == true){
          Out.println("yes");
        }
        else{
          Out.println("no");
        }
    }
    
    private static void DFS(String current, HashMap<String, Boolean> marked, HashMap<String, ArrayList<String>> edges){
      marked.put(current, true);
      
      ArrayList<String> neighbors = edges.get(current);
      for(String neighbor: neighbors){
        if(!marked.get(neighbor)){
          DFS(neighbor, marked, edges);
        }
      }
    }
}
