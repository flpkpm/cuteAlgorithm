import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        return method2(nums, target);
    }

    /**
     * 核心思路，数组中是否存在x,以及target-x的值，暴力穷举的方式是逐个寻找target-x值，所以时间复杂度为O(n^2)
     * 如果使用hash表，只需要利用其是否存在的特性来减少查找的次数
     * @param nums
     * @param target
     * @return
     */
    private int[] method2(int[] nums, int target){
        Map<Integer,Integer> hashTable=new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(hashTable.containsKey(target-nums[i])){
                return new int[]{hashTable.get(target-nums[i]),i};
            }
            hashTable.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    /**
     * 此法为暴力统计法，时间复杂度为O(n^2)
     * @param nums
     * @param target
     * @return
     */
    private int[] method1(int[] nums, int target){
        int index=1;
        for (int i = 0; i < nums.length; i++) {
            for (int j=index; j < nums.length; j++) {
                int sum=nums[i]+nums[j];
                if(sum==target){
                    return new int[]{i,j};
                }
            }
            index++;
        }
        return new int[]{-1,-1};
    }
}
// @lc code=end



