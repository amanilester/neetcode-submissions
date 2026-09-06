class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A;
        int[] B;
        int total = nums1.length + nums2.length;
        int half = total / 2;
        if(nums1.length < nums2.length) {
            A = nums1;
            B = nums2;
        } else {
            A = nums2;
            B = nums1;
        }
        int l = 0, r = A.length;
        while(l <= r) {
            int m = l + (r - l) / 2;
            int j = half - m;
            int Aleft = m > 0 ? A[m - 1] : Integer.MIN_VALUE;
            int Aright = m < A.length ? A[m] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;
            if(Aleft <= Bright && Bleft <= Aright) {
                if(total % 2 == 0) {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0; 
                }
                return Math.min(Aright, Bright);
            } else if(Aleft > Bright) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0.0;
    }
}
