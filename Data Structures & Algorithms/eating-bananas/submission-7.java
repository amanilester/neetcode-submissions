class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = 0;
        for(int i = 0; i < piles.length; i++) {
            maxK = Math.max(maxK, piles[i]);
        }
        int l = 1;
        int r = maxK;
        while(l <= r) {
            int k = l + ((r - l) / 2);
            int temp = 0;
            for(int i = 0; i < piles.length; i++) {
                temp += (int) Math.ceil((double) piles[i] / k);
            }
            if(temp > h) {
                l = k + 1;
            } else {
                maxK = Math.min(maxK, k);
                r = k - 1;
            }
        }
        return maxK;
    }
}
