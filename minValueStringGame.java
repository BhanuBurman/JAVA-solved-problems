//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// creating a pair for storing char and its frequency
class Pair{
    char c;
    int freq;
    Pair(char c, int freq){
        this.c = c;
        this.freq = freq;
    }
}

class Solution{
    static int minValue(String s, int k){
        // code here
        if(s.isEmpty()) return 0;        // base case
        
        // Max heap --> first value will always have maximum
        PriorityQueue<Pair> q = new PriorityQueue<>(new MyCompare());
        // freq map
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        // adding pairs from freqmap to queue
        for(char key:map.keySet()){
            q.add(new Pair(key, map.get(key)));
        }
        
        // removing freqency of the character with highest value and decrease it by one
        // then again push it into queue 
        // keep doing k times
        while(k >0){
            Pair curr = q.poll();
            curr.freq--;
            q.add(curr);
            k--;
        }
        
        // calculate sum of squares from the queue
        int result = 0;
        while(!q.isEmpty()){
            Pair node = q.poll();
            result += Math.pow(node.freq,2);
        }
        return result;
    }
}

// comparator class for building max heap
class MyCompare implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        int count1 = p1.freq;
        int count2 = p2.freq;
        return count2 - (count1);
    }
}
