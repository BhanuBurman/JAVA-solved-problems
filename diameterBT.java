class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        int height = Math.max(left,right)+1;
        
        int dia = left+right+1;
        diameter = Math.max(diameter,dia);
        return height;
        
    }
}
