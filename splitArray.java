class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int start = 0;
        int end = 0;
        int ans = -1;
        for(int num: arr){
            start = Math.max(start,num);
            end += num;
        }
        
        while(start<= end){
            int mid = end + (start - end)/2;
            if(isValid(arr,K,mid)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    private static boolean isValid(int[] arr, int k, int curr){
        int sum = 0;
        int subArr = 1;
        for(int i = 0; i< arr.length; i++){
            sum += arr[i];
            if(sum > curr){
                subArr++;
                sum = arr[i];
            }
            if(subArr > k){
                return false;
            }
        }
        return true;
    }
};
