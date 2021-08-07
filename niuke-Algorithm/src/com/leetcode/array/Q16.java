package com.leetcode.array;

import java.util.Arrays;

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxRes = 0,maxDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int left = i+1,right = n-1;

            while (left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) <= maxDiff) {
                    maxRes = sum;
                    maxDiff = Math.abs(sum - target);
                }
                if (sum - target > 0) {
                    right -- ;
                } else {
                    left ++;
                }
            }


        }
        return maxRes;
    }

    /**
     * 暴力
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest1(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxRes = 0,maxDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n-1; j++) {
                int third = j+1,countMin = 0,countBig,countUse;
                if (third == n-1) {
                    countUse = nums[i] + nums[j] + nums[n-1];
                    if (Math.abs(countUse - target) < maxDiff) {
                        maxDiff = Math.abs(countUse - target);
                        maxRes = countUse;
                    }
                    break;
                }
                while ( (nums[i] + nums[j] + nums[third]) < target) {
                    third ++;
                    if (third == n) {
                        break;
                    }
                }
                if (third == n ) {
                    countUse = nums[i] + nums[j] + nums[n-1];
                }else if (third == j+1){
                    countUse = nums[i] + nums[j] + nums[third];
                }else {
                    countMin = nums[i] + nums[j] + nums[third -1];
                    countBig = nums[i] + nums[j] + nums[third];
                    countUse = target - countMin >= countBig - target? countBig:countMin;
                }

                if (Math.abs(countUse - target) < maxDiff) {
                    maxDiff = Math.abs(countUse - target);
                    maxRes = countUse;
                }
            }
        }
        return maxRes;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,2,1,-4};
//        int target = 1;
//        int[] nums = new int[]{1,2,4,8,16,32,64,128};
//        int target = 82;
//        int[] nums = new int[]{-1,0,1,1,55};
//        int target = 3;
//        int[] nums = new int[]{1,2,5,10,11};
//        int target = 12;
        int[] nums = new int[]{-100,-98,-2,-1};
        int target = -101;
        //[1,2,4,8,16,32,64,128] 82 82 -1,2,1,-4 1 2[]
        //-101
        //[-1,0,1,1,55] 3 2
        //
        Q16 q16 = new Q16();
        System.out.println(q16.threeSumClosest(nums,target));
    }
}
