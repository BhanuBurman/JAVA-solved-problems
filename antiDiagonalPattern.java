class Solution
{
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        // Code here
        int size = matrix.length*matrix.length;
        int[] antiOrder = new int[size];
        
        int i =0, k =0;
        while(i < matrix.length){
            for(int j = 0; j <=i ; j++){
                antiOrder[k++] = matrix[j][i-j];
            }
            i++;
        }
        i--;
        // System.out.println(i);
        int l = 1;
        while(i > 0){
            for(int j = matrix.length-i; j < matrix.length; j++){
                antiOrder[k++] = matrix[j][matrix.length-l];
                l++;
            }
            i--;
            l = 1;
        }
        return antiOrder;
    }
}
