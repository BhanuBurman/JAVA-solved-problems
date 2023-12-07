class Solution
{
	public static int countPairs(Node root1, Node root2, int x)
	{
		// Code here
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		int count = 0;
		traverse(root1,set);
		traverse(root2,set2);
		for(int number: set2){
		    if(set.contains(x-number)){
		        count++;
		    }
		}
		return count;
	}
	
	private static void traverse(Node node, HashSet<Integer> set){
	    if(node == null){
	        return;
	    }
	    set.add(node.data);
	    traverse(node.left,set);
	    traverse(node.right,set);
	}
}
