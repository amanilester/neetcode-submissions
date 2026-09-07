class Solution {
    public int lengthOfLongestSubstring(String s) {

        int maxSub = 0;
        int l = 0, r = 0;
        HashSet<Character> seen = new HashSet<>();
        while(r < s.length()) {
            if(seen.contains(s.charAt(r))) {
                maxSub = Math.max(maxSub, r - l);
                while(s.charAt(l) != s.charAt(r)) {
                    seen.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            seen.add(s.charAt(r));
            r++;
        }
        return Math.max(maxSub, r - l);
    }
}
