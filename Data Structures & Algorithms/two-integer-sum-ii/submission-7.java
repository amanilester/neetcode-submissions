class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while(l < r) {
            int temp = numbers[l] + numbers[r];
            if(temp < target)
                l += 1;
            else if(temp > target)
                r -= 1;
            else
                return new int[]{l + 1, r + 1};
        }
        return new int[]{};
    }
}
