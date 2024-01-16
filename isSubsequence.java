class Solution {
    public boolean isSubsequence(String s, String t) {
        // Handling edge cases
        if(s.isEmpty()) return true;
        if(t.isEmpty()) return false;
        int i = 0, j = 0;
        // Creating char Array for faster access 
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int sLength = s.length();
        int tLength = t.length();
        // i pointer for s String
        // j pointer for t String
        while(i < sLength && j < tLength){
            // When both equals move both the pointers
            if(tArr[j] == sArr[i]){
                i++;
                j++;
            }else{
                // otherwise move only j pointer
                j++;
            }
        }

        // Check if i the pointer is at end Position
        return sLength == i;
    }
}
