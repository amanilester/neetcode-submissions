class Solution {

    public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < strs.size(); i++) {
            output.append(strs.get(i));
            output.append('\0');
        }
        return output.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '\0') {
                output.add(temp.toString());
                temp = new StringBuilder();
            } else {
                temp.append(str.charAt(i));
            }
        }
        return output;
    }
}
