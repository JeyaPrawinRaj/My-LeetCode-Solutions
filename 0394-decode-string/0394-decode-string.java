import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the full number (handles multi-digit k like 100[a])
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current multiplier and current built string to stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset for the new context inside the brackets
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Decode: pop the multiplier and the previous string prefix
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();
                
                // Repeat currentString k times and append to the prefix
                while (currentK-- > 0) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // It's a regular character, just append to current context
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
