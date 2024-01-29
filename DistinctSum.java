//{ Driver Code Starts
//Initial Template for Java

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
            String[] s = br.readLine().trim().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            int[] ans = obj.DistinctSum(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] DistinctSum(int[] nums)
    {
        // Code here
        HashSet<Integer> set = new HashSet<>();
        int sumElement = 0;
        for(int i = 0; i < nums.length; i++){
            sumElement+=nums[i];
        }
        int[][] dp = new int[nums.length][sumElement];
        solve(nums,0,0,set,dp);
        int n = set.size();
        int[] ans = new int[n];
        int i = 0;
        for(int num: set){
            ans[i++] =  num;
        }
        Arrays.sort(ans);
        return ans;
    }
    private void solve(int[] arr, int index, int sum, HashSet<Integer> set, int[][] dp){
        if(index == arr.length){
            set.add(sum);
            return ;
        }
        if(dp[index][sum] != 0) {
            set.add(dp[index][sum]);
            return;
        }
        dp[index][sum] = sum+arr[index];
        solve(arr, index+1,sum + arr[index],set, dp);
        dp[index][sum] = sum;
        solve(arr, index+1,sum,set, dp);
        
    }
}
