class Solution {
    public int characterReplacement(String s, int k) {
        HashSet<Character> chars = new HashSet<>();
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }

        for(Character ch : chars) {
            int l = 0;
            int kTemp = k;
            for(int r = 0; r < s.length(); r++) {
                char rch = s.charAt(r);
                while(kTemp == 0 && rch != ch) {
                    if(s.charAt(l) != ch)
                        kTemp++;
                    l++;
                }
                if(rch != ch) {
                    kTemp--;
                }
                max = Math.max(max, r - l + 1);
            }
        }
        return max;
    }
}
