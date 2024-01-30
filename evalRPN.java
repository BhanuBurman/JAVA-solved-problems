class Solution {
    // to evaluate two variables based on given operation
    private int evaluate(int a, int b,String ops){
        switch (ops){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
        }
        return 0;
    }
    // check if the String is number or not
    private boolean isNumber(String s){
        if(s.length() == 1 && !Character.isDigit(s.charAt(0))) return false;
        return true;
    }
    public int evalRPN(String[] tokens) {
        // base case - if one element
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for(int i = 0; i < tokens.length; i++){
            if(isNumber(tokens[i])){
                // if the number is found then push it into stack
                st.push(Integer.parseInt(tokens[i]));
            }else{
                // other wise get top two elements and evaluate with the current operation
                int b = st.pop();
                int a = st.pop();
                res = evaluate(a,b,tokens[i]);
                // push the evaluated result into stack
                st.push(res);
            }

        }
        return res;
    }
}
