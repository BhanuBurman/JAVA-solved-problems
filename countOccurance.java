class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        // your code here,return the answer
        int ans = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < n ; i++){
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }
        // System.out.println(freq);
        for(int key : freq.keySet()){
            int occur = freq.get(key);
            if(occur > n/k){
                ans++;
            }
        }
        return ans;
        
    }
}
