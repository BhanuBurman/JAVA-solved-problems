class Solution {
    public boolean isAnagram(String s, String t) {
        //Handling the base condition
        if (s.length() != t.length()){
            return false;
        }
       // Initialize the array for all alphabets
        int[] alphabets = new int[26];
        
        // Increase the index number of string s and decrease the index number of string t
        for (int i = 0; i < s.length(); i++) {
            int alphaIndexOne = s.charAt(i) - 'a';
            int alphaIndexTwo = t.charAt(i) - 'a';
            alphabets[alphaIndexOne]++;
            alphabets[alphaIndexTwo]--;
        }
        //check if all the elements in the array is 0
        for (int alphabet : alphabets) {
            if (alphabet != 0) {
                return false;
            }
        }
        return true;
    }
}
