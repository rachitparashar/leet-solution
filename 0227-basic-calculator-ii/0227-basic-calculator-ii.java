class Solution {
    public int calculate(String s) {

        Deque<Integer> stack = new ArrayDeque<>();

        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Build the number
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // Process number when operator is found
            // or when we reach the end
            if ((!Character.isDigit(c) && c != ' ')
                    || i == s.length() - 1) {

                if (sign == '+') {
                    stack.push(num);
                }
                else if (sign == '-') {
                    stack.push(-num);
                }
                else if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }
        }

        // Add all values in the stack
        int ans = 0;

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
}