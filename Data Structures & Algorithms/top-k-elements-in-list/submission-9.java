class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        ArrayList<Integer>[] bucketSort = new ArrayList[nums.length + 1];
        int[] res = new int[k];
        for(int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            bucketSort[i + 1] = new ArrayList<>();
        }

        count.forEach((num, numCount) -> {
            bucketSort[numCount].add(num);
        });
        for(int i = bucketSort.length - 1; i > 0; i--) {
            for(int j = 0; j < bucketSort[i].size(); j++) {
                res[k - 1] = bucketSort[i].get(j);
                k--;
                if(k == 0)
                    return res;
            }
        }
    return res;
    }
}
