class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        // Checking if the board has only one row
        // In this case just return the sum of all the numbers
        if( n == 1){
            int max = 0;
            for(int i = 0; i < m; i++){
                max += M[0][i];
            }
            return max;
        }
        // DP Table
        int[][] dp = new int[n][m];
        for(int j = M[0].length-1; j >= 0 ; j--){
            for(int i = M.length -1 ; i >= 0; i--){
                // Case-1: if the number is in the last column
                if( j == M[0].length -1){
                    dp[i][j] = M[i][j];
                }else if( i == 0){
                    // Case-2: if the number is in the first row
                    dp[i][j] = M[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
                }else if(i == M.length-1){
                    // Case-3: if the number is in last row
                    dp[i][j] = M[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                }else{
                    // Case-4: number is in between the board
                    dp[i][j] = M[i][j] + Math.max(dp[i-1][j+1],Math.max(dp[i][j+1],dp[i+1][j+1]));
                }
            }
        }
        // To print the table
        // for(int[] arr : dp){
        //     System.out.println(Arrays.toString(arr));
        // }
        int max = dp[0][0];
        // getting the answer from first column
        for(int i = 0; i < dp.length; i++){
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}
