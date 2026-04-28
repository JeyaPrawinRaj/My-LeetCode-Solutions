import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            if (ast > 0) {
                stack.push(ast);
            } else {
                // Collision loop: while the top is positive and smaller than the negative ast
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(ast)) {
                    stack.pop();
                }
                
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(ast);
                } else if (stack.peek() == Math.abs(ast)) {
                    stack.pop(); // Both explode
                }
                // If stack.peek() > Math.abs(ast), the current ast explodes (do nothing)
            }
        }

        // Convert Stack to int array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
