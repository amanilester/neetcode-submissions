class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> dups = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(dups.contains(nums[i]))
                return true;
            dups.add(nums[i]);
        }
        return false;
    }
}