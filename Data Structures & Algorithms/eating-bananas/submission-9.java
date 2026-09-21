class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = piles[0];
        for(int i = 0; i < piles.length; i++) {
            r = Math.max(r, piles[i]);
        }
        int l = 1;
        int min = r;
        while(l <= r) {
            int m = l + (r - l) / 2;
            int time = 0;
            for(int i = 0; i < piles.length; i++) {
                time += (int) Math.ceil((double) piles[i] / m);
            }
            if(time <= h) {
                min = Math.min(min, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return min;
    }
}
