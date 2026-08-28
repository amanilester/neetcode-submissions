class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> groups = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
    
        for(int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for(int j = 0; j < strs[i].length(); j++) {
                char tempC = strs[i].charAt(j);
                temp.put(tempC, temp.getOrDefault(tempC, 0) + 1);
            }
            if(!groups.containsKey(temp)) {
                groups.put(temp, new ArrayList<String>());
            }
            groups.get(temp).add(strs[i]);
        }

        for(List<String> anagrams : groups.values()) {
            res.add(anagrams);
        }

        return res;
    }
}
