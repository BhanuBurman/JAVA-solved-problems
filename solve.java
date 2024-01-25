class Solution{
    class Node{
        int dis;
        int number;
        Node(int dis, int number){
            this.dis = dis;
            this.number = number;
        }
    }
    boolean[] primes;
    
    private void getPrimes(){
        this.primes = new boolean[10000];
        Arrays.fill(primes,true);
        for(int i = 2; i*i < 10000; i++){
            for(int j = i*2; j < 10000; j+=i){
                primes[j] = false;
            }
        }
    }
    
    int solve(int num1,int num2){
        //code here
        getPrimes();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,num1));
        
        while(!q.isEmpty()){
            int distance = q.peek().dis;
            int number = q.peek().number;
            q.poll();
            if(number == num2) return distance;
            
            String num = Integer.toString(number);
            
            for(int i = 0; i < 4; i++){
                for(char c = '0'; c <= '9'; c++){
                    if(i == 0 && c == '0' || num.charAt(i) == c) continue;
                    
                    String next = num.substring(0,i) + c + num.substring(i+1);
                    int nxtNumber = Integer.parseInt(next);
                    if(primes[nxtNumber]){
                        primes[nxtNumber] = false;
                        q.add(new Node(distance+1,nxtNumber));
                    }
                }
            }
            
        }
        return -1;
    }
}
