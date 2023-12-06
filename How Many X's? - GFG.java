

// User function Template for Java

class Solution {
    int countX(int L, int R, int X) {
        // code here
        int count =0;
        String target = Integer.toString(X);
        char c = target.charAt(0);
        for(int i = L+1; i < R ; i++){
            String s = Integer.toString(i);
            count += countDigits(s,c);
        }
        return count;
    }
    static int countDigits(String s, char c){
        int count = 0;
        while(!s.isEmpty()){
            if(s.charAt(0) == c){
                count++;
            }
            s = s.substring(1);
        }
        return count;
    }
};
