class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(nums[0], 0);
        for(int i = 1; i < nums.length; i++) {
            if(count.containsKey(target - nums[i])) {
                return new int[]{count.get(target - nums[i]), i};
            }
            count.put(nums[i], i);
        }
        return new int[]{};
    }
}
