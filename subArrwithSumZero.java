class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        //Your code here
        int j = 0, sum = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        while(j < arr.length){
            sum += arr[j];
            if( set.contains(sum)){
                return true;
            }
            set.add(sum);
            j++;
        }
        return false;
    }
}
