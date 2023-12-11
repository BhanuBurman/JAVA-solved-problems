class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int i = 0, j = 0;
        long maxVal = Long.MIN_VALUE, sum = 0;
        while(j < Arr.size()){
            sum += Arr.get(j);
            if(j-i+1 == K){
                maxVal = Math.max(maxVal, sum);
                sum -= Arr.get(i);
                i++;
            }
            j++;
        }
        return maxVal;
    }
}
