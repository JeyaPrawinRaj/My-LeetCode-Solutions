class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push corresponding closing bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // It's a closing bracket
                // Check if stack is empty or top doesn't match
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}