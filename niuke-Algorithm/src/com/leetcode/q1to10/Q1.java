package com.leetcode.q1to10;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class Q1 {
    /**
     * hash位与法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>(length -1);
        for (int i = 0; i < length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i,hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("不存在两数");
    }

    /**
     * 暴力枚举
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {

                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("不存在两数");
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3,2,4};
//        int target = 6;
//        Q1 q1 = new Q1();
//        System.out.println(q1.twoSum2(nums,target)[0]);
//        System.out.println(q1.twoSum2(nums,target)[1]);

        System.out.println(Integer.hashCode(3));
        System.out.println(Integer.hashCode(0));
    }
}
