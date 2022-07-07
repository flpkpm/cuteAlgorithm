/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] resultArr=new int[2];
        int[] arrA=new int[nums.length];
        System.arraycopy(nums, 0, arrA, 0, nums.length); 
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < arrA.length; j++) {
                if(nums[i]+arrA[j]==target){
                    resultArr[0]=j;
                    resultArr[1]=i;
                    break;
                }
            }
        }
        return resultArr;
    }
}
// @lc code=end

