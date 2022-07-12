/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArray =new int[nums1.length+nums2.length];
        int l1=0,l2=0;
        for (int i = 0; i < mergeArray.length; i++) {
            if(nums1.length<nums2.length){
                if(nums1[l1]<=nums2[l2]){
                    mergeArray[i]=nums1[l1];
                    l1++;
                }else{
                    mergeArray[i]=nums1[l2];
                    l2++;
                }
            }

        }
    }
}
// @lc code=end

