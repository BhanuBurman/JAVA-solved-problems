class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] dp = new int[2001];
        for(int i = 0; i < arr.length; i++){
            int index = arr[i]+1000;
            dp[index]++;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < dp.length; i++){
            if(dp[i] != 0){
                if(set.contains(dp[i])){
                    return false;
                }else{
                    set.add(dp[i]);
                }
            }
        }
        return true;
    }
}
