package com.leetcode.array;

import java.util.*;

public class Q37_1 {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        //循环得到所有 空的坐标
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    //加入空位置坐标
                    spaces.add(new int[]{i, j});
                } else {
                    //得到当前数字加入 行 列 box [digit]为ture 避免重复判断
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        //如果 坐标超过边界结束递归
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        //得到当前坐标
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];

        for (int digit = 0; digit < 9 && !valid; ++digit) {
            //判断当前数字在 行列 box不存在 进入填入修改board坐标pos的
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                //将新写入的数字放到 box内
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                //变化pos坐标的数
                board[i][j] = (char) (digit + '0' + 1);
                //继续下一个dfs遍历
                dfs(board, pos + 1);
                //如果递归dfs没有到
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }

    public static void main(String[] args) {

        char[][] target =new char[][]
                {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        char a = '5';
        int[] s = new int[a - '0'];
        new Q37().solveSudoku(target);
        System.out.println(Arrays.deepToString(target));

    }
}
