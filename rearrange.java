class Solution {
    void rearrange(int A[], int n) {
        // code here
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        
        for(int i =0; i < n; i++){
            if(A[i]>=0){
                pos.offer(A[i]);
            }else {
                neg.offer(A[i]);
            }
        }
        int i = 0;
        while(!pos.isEmpty() && !neg.isEmpty()){
            A[i] = pos.poll();
            A[i+1] = neg.poll();
            i+=2;
        }
        while(!pos.isEmpty()){
            A[i] = pos.poll();
            i++;
        }
        while(!neg.isEmpty()){
            A[i] = neg.poll();
            i++;
        }
    }
}
