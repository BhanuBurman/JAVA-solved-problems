
class Solution {
    public static long sumOfPowers(long a, long b) {
        // code here
        long ans = 0;
        // iterate from the range a to b
        for(long i =a; i <= b; i++){
            ans += primes(i);
        }
        return ans;
    }
    private static long primes(long n){
        long ans = 0;
        // iterate from 2 to i
        for(int i = 2; i*i <= n; i++){
            // if the ith element can divide the number then we can take it as answer
            while(n%i ==0){
                ans++;
                n/=i;
            }
        }
        // when the number is itself a prime number i.e. 11^1
        if( n != 1){
            ans++;
        }
        return ans;
    }
}
