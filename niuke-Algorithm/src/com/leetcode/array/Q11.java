package com.leetcode.array;

public class Q11 {
    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea=0,left=0,right=height.length-1;
        while (left< right) {
            maxArea = height[left] < height[right] ?
                    Math.max(maxArea, (right-left) * height[left++]):
                    Math.max(maxArea, (right-left) * height[right--]);
        }
        return maxArea;
    }

//    public int maxArea(int[] height) {
//        int max = 0;
//        System.out.println(height.length);
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i+1; j < height.length; j++) {
//                int temp = (j - i) * Math.min(height[i],height[j]);
//                if (temp > max) {
//                    max = temp;
//                }
//            }
//            System.out.println(i);
//        }
//        return max;
//    }

    public static void main(String[] args) {
        int []height = new int[]{2,3,4,5,18,17,6};//2,3,4,5,18,17,6
        Q11 q11 = new Q11();
        System.out.println(q11.maxArea(height));
    }
}
