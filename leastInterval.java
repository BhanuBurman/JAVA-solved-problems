class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0; // our answer

        // Creating frequency array for tasks
        int[] freq = new int[26];
        for(int i = 0; i < tasks.length; i++){
            int index = tasks[i]-'A';
            freq[index]++;
        }

        // Max Heap --> returns max element
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });

        for(int i = 0; i< 26; i++){
            if(freq[i] > 0){
                q.offer(freq[i]);
            }
        }
        
        while(!q.isEmpty()){
            // list for storing the no of tasks can be done within n+1 time
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 1; i <= n+1; i++){
                if(!q.isEmpty()){
                    int f = q.poll();
                    f--;
                    temp.add(f);
                }
            }
            // again add the tasks having freq ">0" to the pq from the temp; 
            for(int i =0; i < temp.size(); i++){
                int num = temp.get(i);
                if(num > 0){
                    q.offer(num);
                }
            }
            // Attention: 
            // if pq is not empty means that we had enough unique tasks to complete
            // so we can do it within n+1 time
            // but if the pq is empty it might be the possibility that we had less tasks
            // than the given cool down time so on that case just add temp.size() --> but why ?
            // because what if the only element is remaining in the queue and no other task is there
            // means we are in the last task then we have to count only last element not the gaps
            // Ex. AB_|AB_|A            --> n=2
            // here int the last position no need to put the extra two _ _ because you are now at the end of the tasks  
            if(q.isEmpty()){
                time += temp.size();
            }else{
                time += n+1;
            }
        }
        return time;
    }
}
