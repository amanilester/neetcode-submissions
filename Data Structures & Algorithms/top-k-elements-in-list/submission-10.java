class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] appearCount = new List[nums.length + 1];
        int kCount = 0;
        int[] res = new int[k];
        for(int i = 1; i < appearCount.length; i++) {
            appearCount[i] = new ArrayList<Integer>();
        }
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            numCount.put(temp, numCount.getOrDefault(temp, 0) + 1);
        }

        for(Integer key : numCount.keySet()) {
            int value = numCount.get(key);
            appearCount[value].add(key);
        }

        for(int i = appearCount.length - 1; i >= 1; i--) {
            for(int j = 0; j < appearCount[i].size(); j++) {
                res[kCount] = appearCount[i].get(j);
                kCount++;
                if(kCount == k)
                    return res;
            }
        }
        return res;
    }
}
