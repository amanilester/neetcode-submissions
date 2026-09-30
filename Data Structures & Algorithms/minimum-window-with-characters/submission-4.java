class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int[] minIndex = {-1, -1};
        int have = 0;
        for(int i = 0; i < t.length(); i++) {
            char tc = t.charAt(i);
            tMap.put(tc, tMap.getOrDefault(tc, 0) + 1);
            sMap.put(tc, 0);
        }

        int need = tMap.size();
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char sc = s.charAt(r);
            if(!tMap.containsKey(sc))
                continue;
            sMap.put(sc, sMap.getOrDefault(sc, 0) + 1);
            if(sMap.get(sc).equals(tMap.get(sc)))
                have++;
            while(have == need) {
                char lc = s.charAt(l);
                if(r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    minIndex[0] = l;
                    minIndex[1] = r;
                }
                if(sMap.containsKey(lc) && sMap.get(lc).equals(tMap.get(lc))) {
                    have--;
                }
                if(sMap.containsKey(lc))
                    sMap.put(lc, sMap.get(lc) - 1);
                l++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minIndex[0], minIndex[1] + 1);
    }
}
