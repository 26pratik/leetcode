class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int high = m+n-1;
        
        while(m > 0 && n > 0) {
            if(nums1[m-1] > nums2[n-1]) {
                nums1[high] = nums1[m-1];
                high--;
                m--;
            }
            else {
                nums1[high] = nums2[n-1];
                high--;
                n--;
            }
        }
        
        if(n > 0) {
            for(int i = high; i>=0; i--) {
                nums1[i] = nums2[n-1];
                n--;
            }
        }

        if(m > 0) {
            for(int i = high; i>=0; i--) {
                nums1[i] = nums1[m-1];
                m--;
            }
        }
    }
}