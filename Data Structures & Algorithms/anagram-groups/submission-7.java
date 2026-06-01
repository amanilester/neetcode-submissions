class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> mappings = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for(int j = 0; j < strs[i].length(); j++) {
                char character = strs[i].charAt(j);
                temp.put(character, temp.getOrDefault(character, 0) + 1);
            }
            if(!mappings.containsKey(temp)) {
                List<String> list = new ArrayList<>();
                mappings.put(temp, list);
            }
            mappings.get(temp).add(strs[i]);
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> value : mappings.values()) {
            res.add(value);
        }
        return res;
    }
}
