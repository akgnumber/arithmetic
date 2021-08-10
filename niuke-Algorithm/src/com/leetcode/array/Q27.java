package com.leetcode.array;

import java.util.Arrays;

public class Q27 {

    /**
     * 双指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int l = 0,r = n-1;
        while (l < r) {
            while (nums[r] == val) {
                r--;
            }
            if (nums[l] == val) {
                nums[l] = nums[r];
                nums[r] = val;
                r--;
            }
            l++;
        }

        return l;
    }

    /**
     * 循环保留满足值
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        int n = nums.length;
        int l = 0,f = 0;
        while (f < n) {
            if (nums[f] != val) {
                nums[l] = nums[f];
                l++;
            }
            f++;
        }

        return l++;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(new Q27().removeElement(nums,val));

        for (int i:nums){
            System.out.print(":"+i);
        }
    }

}
