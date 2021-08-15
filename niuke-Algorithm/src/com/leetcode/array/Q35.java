package com.leetcode.array;

/**
 * 查找插入下表
 */
public class Q35 {
    /**
     * 自写
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length,l=0,r=n-1;
        if (n == 1) {
            return nums[0] >= target ? 0 : 1;
        }
        while (l < r) {
            int mid = (l + r) /2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid -1;
            } else {
                l = mid +1;
            }
        }
        if (target > nums[l]) {
            return ++l;
        }
        return l;
    }

    public static void main(String[] args) {
        Q35 q35 = new Q35();
        System.out.println(q35.searchInsert(new int[]{1,3,5,6,10,20},2));
    }
}
