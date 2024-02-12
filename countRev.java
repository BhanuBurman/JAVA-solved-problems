class Sol
{
    int countRev (String s)
    {
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        if( arr.length%2 != 0) return -1;
        for(int i = 0; i < arr.length; i++){
            if(!st.isEmpty() && arr[i] == '}' && st.peek() == '{'){
                st.pop();
            }else{
                st.push(arr[i]);
            }
        }
        
        // This is critical part and need to give a look
        // First logic comes in the mind that just return st.size()/2 --> wrong
        // {} --> only one ops needed
        // }{ --> two ops needed
        // thus check if the chars equal if so then increase counter by one otherewise 2
        
         int count =0;
        while(!st.isEmpty())
        {
            char ch1 = st.pop();
            char ch2 = st.pop();
            if(ch1==ch2)
            {
                count=count+1;
            }
            else
            {
                count=count+2;
            }
        }
        return count;
               
    }
}
