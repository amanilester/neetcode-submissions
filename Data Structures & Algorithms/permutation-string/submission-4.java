class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1chs = new HashMap<>();
        HashMap<Character, Integer> s2chs = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            char temp = s1.charAt(i);
            s1chs.put(temp, s1chs.getOrDefault(temp, 0) + 1);
        }
        int l = 0;
        for(int r = 0; r < s2.length(); r++) {
            char rch = s2.charAt(r);
            if(!s1chs.containsKey(rch)) {
                s2chs.clear();
                l = r + 1;
                continue;
            }
            while(s2chs.containsKey(rch) && 
            s2chs.get(rch) == s1chs.get(rch)) {
                char temp = s2.charAt(l);
                s2chs.put(temp, s2chs.get(temp) - 1);
                l++;
            }
            s2chs.put(rch, s2chs.getOrDefault(rch, 0) + 1);
            if(s2chs.equals(s1chs))
                return true;
        }
        return false;
    }
}
