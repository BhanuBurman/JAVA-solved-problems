class Solution{
    
    static long countSubarrays(int a[], int n, int L, int R)  
    { 
        // Complete the function
        int i=0, j = 0, len = 0;
        long ans = 0;
        while(j < n){
            if(a[j] <= R && a[j] >= L){
                // Storing window length if found a valid value
                len = j-i+1;
            }
            if(a[j] > R){
                // This a[j] cannot be included hence we need to break the window
                // also make the calculated length to zero
                len = 0;
                i = j+1;
            }
            
            // Here Just add the len we calculated above and add it to answer, Why?
            // Note: Rule --> SubArray which has the last element in it will be equal to the size of that array
            // No. of subarray == size of the subarray till that number
            ans += len;
            j++;
        }
        return ans;
    } 
}
