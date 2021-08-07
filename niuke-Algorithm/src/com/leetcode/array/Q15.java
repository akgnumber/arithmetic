package com.leetcode.array;

import java.util.*;

public class Q15 {
    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(nums[2]);
        for (int i = 0; i < n - 2; i++) {
            int target = - nums[i];
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int third = n -1;
            for (int j = i +1; j < third; j++) {
                if (j > i  && nums[j] == nums[j+1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (j < third && nums[j] + nums[third] > target) {
                    --third;
                }
                if (j == third) {
                    break;
                }
                if (nums[j] + nums[third] == target) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list1.add(nums[third]);
                    list.add(list1);
                }


            }
        }
        return list;

    }

    public static void main(String[] args) {
        Q15 q15 = new Q15();
        System.out.println(q15.threeSum(new int[]{-1,0,1,0}));
    }
}
