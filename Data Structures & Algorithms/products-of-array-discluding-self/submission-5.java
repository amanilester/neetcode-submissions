class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] res = new int[nums.length];
        prefix[0] = nums[0];
        suffix[suffix.length - 1] = nums[suffix.length - 1];
        for(int i = 1; i < prefix.length; i++) {
            prefix[i] = nums[i] * prefix[i - 1];
        }
        for(int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = nums[i] * suffix[i + 1];
        }
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                res[i] = suffix[i + 1];
            } else if(i == nums.length - 1) {
                res[i] = prefix[i - 1];
            } else {
                res[i] = prefix[i - 1] * suffix[i + 1];
            }
        }
        return res;
    }
}  
