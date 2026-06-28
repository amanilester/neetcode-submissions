class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> mappings = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        mappings.put('(',')');
        mappings.put('{','}');
        mappings.put('[',']');
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(mappings.containsKey(temp)) {
                stack.push(mappings.get(temp));
            } else if(!stack.empty() && temp == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        if(stack.empty())
            return true;
        return false;
    }
}
