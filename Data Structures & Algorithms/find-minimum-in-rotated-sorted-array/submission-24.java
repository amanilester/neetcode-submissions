class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, min = nums[0];
        while(l <= r) {
          if(nums[l] <= nums[r])
            return Math.min(min, nums[l]);

          int m = l + (r - l) / 2;
          min = Math.min(min, nums[m]);
          if(nums[m] >= nums[l])
            l = m + 1;
          else
            r = m - 1;
        }
        return min;
    }
}
