//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int r = 0, c = 0;
        int[] res = new int[n*n];
        for(int i = 0;i < n*n ; i++){
            // storing the result linearly
            res[i] = mat[r][c];
            // if the point is even then move up-right
            if((r+c)%2 == 0){
                // ex. (0,2)
                if(c == n-1){
                    r++;
                }else if(r == 0){
                // ex. (0,0)
                    c++;
                }else{
                // ex. (2,0)
                    r--;
                    c++;
                }
                    
            }else{
            // if the point is odd then move down-left
                if(r==n-1){
                // ex. (2,1)
                    c++;
                }else if(c == 0){
                // ex. (1,0)
                    r++;
                }else{
                // ex. (0,1)
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
