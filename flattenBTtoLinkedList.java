class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        if(root.left != null){
            // If the left node is not empty then we need to assgin it in right side
            // Thus, store the right subtree into a temp variable
            TreeNode temp = root.right;
            // Make the left subtree to right subtree
            root.right = root.left;

            // Make the left sub tree null as well (Mentioned in the question)
            root.left = null;

            // Now we need to reach to the end of the right subtree so that we can add the temp sub-tree into it
            TreeNode curr = root.right;
            // Iterate untill found last element
            while(curr.right != null){
                curr = curr.right;
            }
            // just add the temp subtree to the last node
            curr.right = temp;
        }
        // Call recursively for the right subtree
        flatten(root.right);
    }
}
