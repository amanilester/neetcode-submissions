class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for(int r = 0; r < nums.length; r++) {
            if(!q.isEmpty() && l > q.getFirst())
                q.removeFirst();
            while(!q.isEmpty() && nums[r] > nums[q.getLast()])
                q.removeLast();
            q.addLast(r);

            if(r + 1 >= k) {
                res[l] = nums[q.getFirst()];
                l++;
            }
        }
        return res;
    }
}
