class Solution {
    public int reverse(int x) {
        // Checking if the number is negative
        boolean isNegative = false;
        if(x < 0){
            isNegative = true;
        }
        int temp = Math.abs(x);
        int max = Integer.MAX_VALUE;
        int base = (int)Math.pow(10,9);
        // case when reverse of the number exceeds integer limit
        if(temp/base > 0){
            
                while( temp > 0){
                    if((max/base)%10 < temp%10) return 0;
                    if((max/base)%10 > temp%10) break;
                    temp /= 10;
                    base /= 10;
            }
        }
        // System.out.println(Integer.MAX_VALUE);
        temp = Math.abs(x);
        int ans = 0;
        // reversing the number
        while(temp > 0){
            int digit = temp%10;
            ans = ans*10 + digit;
            temp /=10;
            base /=10;
        }
        return isNegative?-1*ans:ans;
    }
}
