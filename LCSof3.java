//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException 
    { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        int[][][] dp = new int[n1+1][n2+1][n3+1];
        
        for(int[][] rowCol : dp){
            for(int[] row: rowCol){
                Arrays.fill(row, -1);
            }
        }
        return solve(A,B,C,n1,n2,n3,dp);
        
        
    }
    private int solve(String A, String B, String C, int n1, int n2, int n3, int[][][] dp){
        if(n1 == 0 || n2 == 0 || n3 == 0) return dp[n1][n2][n3] =0;
        
        
        if(dp[n1][n2][n3] != -1) return dp[n1][n2][n3];
        if(A.charAt(n1-1) == B.charAt(n2-1) && B.charAt(n2-1) == C.charAt(n3-1)){
            return dp[n1][n2][n3] = 1 + solve(A,B, C, n1-1,n2-1,n3-1,dp);
        }
        return dp[n1][n2][n3] = Math.max(
            solve(A, B, C, n1-1,n2,n3,dp),
            Math.max(
            solve( A, B, C,n1,n2-1,n3,dp),
            solve( A, B, C,n1,n2,n3-1,dp)
            ));
    }
}
