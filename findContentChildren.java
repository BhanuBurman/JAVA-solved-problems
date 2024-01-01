class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0) return
        int count =0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int i = 0;
        while( j < g.length && i < s.length){
            if(s[i] >= g[j]){
                count++;
                j++;
                i++;
            }else{
                i++;
            }
        }
        return count++;
    }
}
