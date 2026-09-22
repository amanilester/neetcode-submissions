class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> substring = new HashSet<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char letter = s.charAt(r);
            if(substring.contains(letter)) {
                max = Math.max(max, substring.size());
                while(s.charAt(l) != letter) {
                    substring.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            substring.add(letter);
        }
        return Math.max(max, substring.size());
    }
}
