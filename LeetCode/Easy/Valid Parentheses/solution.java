class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.length() == 1) return false;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{' || stack.empty()){
                stack.push(ch);   
            } else {
                if(ch == ')' && stack.peek() != '(') return false;
                else if(ch == '}' && stack.peek() != '{') return false;
                else if(ch == ']' && stack.peek() != '[') return false;
                else stack.pop();     
            }
        }

        if(stack.empty()) return true;
        else return false;
      
    }
}