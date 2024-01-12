// User function Template for Java

class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        int[] arr = new int[k];
        // System.out.println(q);
        for(int i = 0; i < k; i++){
            arr[i] = q.poll();
        }
        for(int i = k-1; i >= 0; i--){
            q.offer(arr[i]);
        }
        for(int i = 0; i < q.size()-k; i++){
            q.offer(q.poll());
        }
        return q;
    }
}
