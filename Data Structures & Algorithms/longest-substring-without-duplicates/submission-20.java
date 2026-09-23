class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> substring = new HashSet<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char letter = s.charAt(r);
            max = Math.max(max, substring.size());
            while(substring.contains(letter)) {
                substring.remove(s.charAt(l));
                l++;
            }
            substring.add(letter);
        }
        return Math.max(max, substring.size());
    }
}
