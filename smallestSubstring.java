
class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int ans = Integer.MAX_VALUE,i = 0,count = 0 ;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int j = 0; j < S.length(); j++){
            char c = S.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            count = map.size();
            while(count == 3){
                ans = Math.min(ans,j-i+1);
                char chi = S.charAt(i);
                map.replace(chi,map.get(chi)-1);
                if(map.get(chi) == 0){
                    map.remove(chi);
                    count--;
                }
                i++;
            }
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }
};
