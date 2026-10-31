class Solution {
    public int trap(int[] height) {
        int[] maxRight = new int[height.length];
        int[] maxLeft = new int[height.length];
        int total = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            if(i < height.length - 1)
                maxRight[i] = Math.max(maxRight[i + 1], height[i]);
            else
                maxRight[i] = height[i];
        }
        for(int i = 0; i < height.length; i++) {
            if(i == 0)
                maxLeft[i] = height[i];
            else
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
            total += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return total;
    }
}
