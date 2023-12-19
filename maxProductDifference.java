class Solution {
    public int maxProductDifference(int[] nums) {
        int max1 = 0;
        int min1 = Integer.MAX_VALUE;
        int max2 = 0;
        int min2 = Integer.MAX_VALUE;

        //creating index for max1 and max2
        int indexM1 = 0, indexM2 = 0;
        // find max1 and min1
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > max1 ){
                max1 = nums[i];
                indexM1 = i;
            }
            if(nums[i] < min1 ){
                min1 = nums[i];
                indexM2= i;
            }
        }
        //find max2 and min2
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > max2 && i != indexM1){
                max2 = nums[i];
            }
            if(nums[i] < min2 && i != indexM2){
                min2 = nums[i];
            }
        }   
        return (max1*max2 - min1*min2);
    }
}
