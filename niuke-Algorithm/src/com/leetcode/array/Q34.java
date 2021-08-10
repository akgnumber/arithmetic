package com.leetcode.array;

/**
 *给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q34 {
    /**
     * 自写二分
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearchLeft(nums, target);
        int rightIdx = binarySearchRight(nums, target);
        return new int[]{leftIdx,rightIdx};
    }

    private int binarySearchRight(int[] nums, int target) {
        int l = 0, n = nums.length, r = n-1,leftIdx=-1;
        while (l <= r) {
            int mid = (l + r) /2;
            if (nums[mid] == target) {
                leftIdx = mid;
                l = mid+1;
            }
            if (nums[mid] > target){
                r = mid - 1;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return leftIdx;
    }

    private int binarySearchLeft(int[] nums, int target) {
        int l = 0, n = nums.length, r = n-1,leftIdx=-1;
        while (l <= r) {
            int mid = (l + r) /2;
            if (nums[mid] == target) {
                leftIdx = mid;
                r = mid-1;
            }
            if (nums[mid] > target){
                r = mid - 1;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return leftIdx;
    }

    /**
     * 官方解法
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
