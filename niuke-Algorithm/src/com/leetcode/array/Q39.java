package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。

 candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。

 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 示例 1：

 输入: candidates = [2,3,6,7], target = 7
 输出: [[7],[2,2,3]]
 示例 2：

 输入: candidates = [2,3,5], target = 8
 输出: [[2,2,2,2],[2,3,3],[3,5]]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/combination-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q39 {


    /**
     * 官方解
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target,
                    List<List<Integer>> ans,
                    List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    /**
     * 自写
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates[0] == target) {
            List<Integer> list = new ArrayList<>();
            list.add(target);
            lists.add(list);
            return lists;
        }

        dfs(candidates,target,0,0,new ArrayList<Integer>(),lists);

        System.out.println(lists);
        return lists;
    }

    public void dfs(int[] candidates, int target, int index,int sum,List<Integer> list,List<List<Integer>> lists) {

        if (sum == target ) {
            lists.add(new ArrayList<>(list));
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            sum = sum + candidates[i];

            if (sum > target) {
                return;
            }
            list.add(candidates[i]);
            dfs(candidates,target,i,sum,list,lists);
            list.remove(list.size()-1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        Q39 q39 = new Q39();
        System.out.println(q39.combinationSum(new int[]{2,3,6,7},7));
//        System.out.println(lists);
    }
}
