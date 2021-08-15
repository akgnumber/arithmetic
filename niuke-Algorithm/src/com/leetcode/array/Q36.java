package com.leetcode.array;

/**
 * 判断数组是否满足数独
 */
public class Q36 {
    /**
     * 自写 可优化将判断 行列 box放入循环内少一维
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int number = board[i][j] -'0';
                    int boxNumber = j/3 + (i/3*3);
                    if (rows[i][number] || columns[j][number] || box[boxNumber][number]) {
                        return false;
                    }

                    columns[j][number] = true;
                    rows[i][number] = true;
                    box[boxNumber][number] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        boolean[] a = new boolean[1];
//        System.out.println(a[0]);
        char[][] target =new char[][]
                {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        char a = '5';
        int[] s = new int[a - '0'];
        System.out.println(new Q36().isValidSudoku(target));
    }
}
