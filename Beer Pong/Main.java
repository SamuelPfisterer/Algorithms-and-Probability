import algorithms.*;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test3.in");
        Out.compareTo("public/test3.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
        
        // Uncomment this line if you want to read from a file
        // In.close();
    }
    
    static double[][][] dp;
    static double lager;
    static int n;
    static double ale;
    static double cups;
    static double p;
    static double f;
    
    

    public static void testCase() {
        // Input using In.java class
        n = In.readInt();
        ale = (double)In.readInt();
        lager = (double)In.readInt();
        cups = ale+lager;
        int q = In.readInt();
        p = In.readDouble();
        f = In.readDouble();
        
        if(q==1){
          Out.println((lager/cups) * p);
        }
        if(q==2){
          double intersection = p*(ale/cups)*p*f*(lager/(cups-1));
          double second = p*(1-p)*lager/cups + p*p*f*((ale/cups)*(lager/(cups-1)) + (lager/cups)*((lager-1)/(cups-1)));
          Out.println(intersection/second);
        }
        
        dp = new double[(int)n+1][(int)(lager+1)][2];
        for(int i = 0; i <= n; i++){
          for(int j = 0; j <= lager; j++){
            dp[i][j][0] = -1;
            dp[i][j][1] = -1;
          }
        }
        
        if(q==3){
          double onlyLager = 0;
          double factor = 1;
          for(int i =0; i <n; i++){
            factor *= (lager-i)/(cups-i);
          }
          
          double factor2 = 1;
          
          for(int i = 0; i <n-1;i++){
            factor2 *= (lager-i)/ (cups-i);
          }
          
          if(lager >=n){
            onlyLager = Math.pow(p, n)*Math.pow(f, n-1)*factor;
          }
          double oneAle = 0;
          
          if(lager >= n-1 && ale>=1){
            oneAle = n*factor2*Math.pow(p,n)*Math.pow(f,n-1)*(ale)/(cups-n+1);
          }
          double oneMissBase = factor2*Math.pow(p,n-1)*Math.pow(f,n-2)*(1-p);
          double oneMiss = 0;
          for(int i = 0; i<=n-1; i++){
            oneMiss += oneMissBase*Math.pow(f,-i);
          }
          double oneLess = compute(n, n-1, 1) + compute(n, n-1, 0) + compute(n,n,0);
          
          Out.println(compute(n,n,0) + compute(n,n-1,0) +compute(n,n-1,1));
        }
        
        
        
        
    }
    
    private static double compute(double i, double j, double z){
      if(j>lager || (z > ale) || (j+z> i) || (z<0) || (j<0)){
        return 0;
      }
      
      
      if(i==0){
        return 1;
      }
      if(z+j == 0){
        if(i>1){
          return 0;
        }
        else{
          return (1-p);
        }
      }
      
      if(i==1){
        if(z==1){
          return p * ale/cups;
        }
        else{
          return lager *p /cups;
        }
      }
       
      if(dp[(int)i][(int)j][(int)z] != -1){
        return dp[(int)i][(int)j][(int)z];
      } 
      
      
      double not = compute(i-1, j, z)*(1-p*Math.pow(f,j+z));
      double gotLager = compute(i-1, j-1, z)*p*Math.pow(f, j-1+z)*((lager - j + 1)/(cups-j+1-z));
      double gotAle = compute(i-1, j, 0)*p*Math.pow(f,j)*(ale/(cups-j));
      if(z==1){
        dp[(int)i][(int)j][(int)z]= not + gotLager + gotAle;
      }
      else{
        dp[(int)i][(int)j][(int)z] = not + gotLager;
      }
      return dp[(int)i][(int)j][(int)z];
      
    }
}
