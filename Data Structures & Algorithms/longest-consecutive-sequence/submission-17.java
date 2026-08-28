class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int maxSeq = 0;
        for(int i = 0; i < nums.length; i++) {
            seen.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++) {
            if(!seen.contains(nums[i] - 1)) {
                int temp = 1;
                while(seen.contains(nums[i] + temp)) {
                    temp++;
                }
                maxSeq = Math.max(maxSeq, temp);
            }
        }
        return maxSeq;
    }
}
