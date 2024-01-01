class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        
        // stores the freq of remainders of the elements
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int rem = num%k;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        for(int i = 0; i < nums.length; i++){
            int rem = nums[i]%k;
            if(rem == 0){
                // 0 --> even
                int freqX = map.get(rem);
                if ((freqX & 1) == 1) return false;
            }else if(2*(rem) == k){
                // k/2 --> even
                int freqX = map.get(rem);
                if ((freqX & 1) == 1) return false;
            }else{
                //  freq(x) != freq(k-x)
                int freqX = map.get(rem);
                int freqK_X = map.getOrDefault((k-rem),-1);
                if(freqX != freqK_X){
                    return false;
                }
                
            }
        }
        return true;
    }
}
