package com.leetcode.array;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。 
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q40 {

    /**
     * 根据答案修改
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>(candidates.length);
        Arrays.sort(candidates);
        dfs(candidates, target, lists, list, 0, 0);
        return lists;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> lists, Deque<Integer> list, int sum, int index) {
        if (sum == target) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(sum>target){return;}

            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.addLast( candidates[i]);
            dfs(candidates, target, lists, list, sum + candidates[i], i+1);
            list.removeLast();
        }
    }

    /**
     * 答案
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>(candidates.length);
        Arrays.sort(candidates);

        dfs(candidates, candidates.length, 0, target, path, lists);
        return lists;
    }

    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - candidates[i] < 0) {
                break;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            // 调试语句 ①
            // System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, target - candidates[i], path, res);

            path.removeLast();
            // 调试语句 ②
            // System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));

        //[10,1,2,7,6,1,5]
        //8
    }
}
