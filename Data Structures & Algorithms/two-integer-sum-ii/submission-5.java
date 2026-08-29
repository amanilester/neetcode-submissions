class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            if(seen.containsKey(target - numbers[i]))
                return new int[]{seen.get(target - numbers[i]), i + 1};
            seen.put(numbers[i], i + 1);
        }
        return new int[]{};
    }
}
