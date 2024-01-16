class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return helper(n,dp);
        
    }
    private int helper(int n , int[] dp){
        if(n == 1 || n == 0){
            return dp[n] = 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int left = helper(n-1,dp);
        int right = helper(n-2,dp);
        return dp[n] = left +right;
    }
}
