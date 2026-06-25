class Solution {
    public int longestConsecutive(int[] nums) {
        ArrayList<Integer> numArray = new ArrayList<>();
        if(nums.length == 0)
            return 0;
        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            numArray.add(nums[i]);  
        }
        for(int i = 0; i < nums.length; i++) {
            int compare = nums[i] - 1;
            int temp = 1;
            while(numArray.contains(compare)) {
                temp++;
                compare--;
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
