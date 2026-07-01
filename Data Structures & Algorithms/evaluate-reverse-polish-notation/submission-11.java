class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        HashSet<String> symbols = new HashSet<>();
        symbols.add("+");
        symbols.add("-");
        symbols.add("*");
        symbols.add("/");
        for(int i = 0; i < tokens.length; i++) {
            if(!symbols.contains(tokens[i])) {
                stack.add(Integer.parseInt(tokens[i]));
            } else {
                if(tokens[i].equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                } else if(tokens[i].equals("-")) {
                    int b = stack.pop();
                    stack.push(stack.pop() - b);
                } else if(tokens[i].equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else {
                    int b = stack.pop();
                    stack.push(stack.pop() / b);
                }
            }
        }
        return stack.peek();
    }
}
