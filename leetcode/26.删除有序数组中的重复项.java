/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    /**
     * 原地删除重复元素，首先想到的是快慢指针，快指针负责寻找重复因子，慢指针负责删除替换等修改活动
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int slow=0, fast=1;
        while(fast<nums.length){
            if(nums[fast]!=nums[slow]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
// @lc code=end

