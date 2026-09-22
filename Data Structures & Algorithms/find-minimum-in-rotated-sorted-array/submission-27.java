class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = nums[0];
        while(l <= r) {
          int m = l + (r - l) / 2;
          if(nums[l] <= nums[r])
            return Math.min(min, nums[l]);
          min = Math.min(min, nums[m]);
          if(nums[l] > nums[m]) {
            r = m - 1;
          } else {
            l = m + 1;
          }
        }
        return min;
    }
}
