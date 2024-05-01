import algorithms.*;

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
    
    static double m; 
    static double[] c;
    static int n;
    static double[][] dp;

    public static void testCase() {
        // Input using In.java class
        n = In.readInt();
        m = (double) In.readInt();
        
        c = new double[n+1];
        
        for(int i = 1; i <=n; i++){
          c[i] = (double) In.readInt();
        }
        
        dp = new double[(int)m+1][n+1];
        
        for(int i = 0; i <=m; i++){
          for(int j = 0; j <= n; j++){
            dp[i][j] = -1;
          }
        }
        double out = 0;
        for(int j = 1; j <=n; j++){
          out += compute(0,j) * c[j]/m;
        }
        Out.println(out);
        // Output using Out.java class
        
    }
    
    private static double compute(double i, int j){
      if(m-i -1 == 0 || c[j] == 0 || j > n || i > m){
        return 0;
      }
      
      double direct = (c[j] - 1) / (m - i - 1);
      double higher = 0;
      
      if(dp[(int)i][j] != -1){
        return dp[(int)i][j];
      }
      
      for(int nextJ = j +1; nextJ <= n; nextJ++){
        higher+= compute(i+1, nextJ)* c[nextJ] / (m-i-1);
      }
      dp[(int)i][j] = direct + higher;
      
      
      return dp[(int)i][j];
      
      
    }
      
      
}
