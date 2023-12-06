class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root)
    {
        // Returning a helper function with additional parameters
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    static boolean check(Node node, int min, int max){
        if(node == null){
            return true;
        }
        // if the node value exceeds the range of value a node can have then return false
        if(node.data < min || node.data > max){
            return false;
        }
        // otherwise recursively check for both child nodes
        return check(node.left,min,node.data-1) && check(node.right,node.data+1,max);
    }
}
