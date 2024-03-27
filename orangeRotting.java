class Solution {
    class Pair{
        int r;
        int c;
        int t;
        Pair(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int totalFresh = 0;
        // Initially find out all the rotten oranges and push it into queue and 
        // mark on visited array
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j,0));
                    visited[i][j] = 2;
                }
                if(grid[i][j] == 1){
                    totalFresh++;
                }
            }
        }
        int maxTime = 0;
        // Delta rows and cols for getting adjecent cells
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int fresh = 0;
        // performing BFS
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int t = curr.t;
            maxTime = Math.max(t,maxTime);
            // applying operation in each adj cell
            for(int i = 0; i < 4; i++){
                int currRow = r + delRow[i];
                int currCol = c + delCol[i];
                // checking boundary conditions
                if(currRow < n && currCol < m && currRow >=0 && currCol >= 0 &&
                grid[currRow][currCol] == 1 && visited[currRow][currCol] != 2){
                    // if passed boundary conditions just push it into queue and 
                    // visited arr
                    q.offer(new Pair(currRow, currCol,t+1));
                    visited[currRow][currCol] = 2;
                    fresh++;
                }
            }
        }

        // Now we need to check whether any cell is left out which is --
        // fresh but can not be traversed 
        // Note: this method is costly so creating extara count variable for
        // counting the number of fresh oranges
        // for(int i = 0; i< n; i++){
        //     for(int j = 0; j < m; j++){
        //         if(visited[i][j] != 2 && grid[i][j] == 1){
        //             return -1;
        //         }
        //     }
        // }

        // optimized checking 
        if(totalFresh != fresh) return -1;

        return maxTime;
    }
}
