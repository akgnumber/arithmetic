package com.leetcode.array;

import java.util.*;

public class Q37 {
    public static int count = 0;

    int len = 9;
    char[][] board;

    // 这么初始化 爱了
    // 你要是ArrayList<ArrayList<ArrayList<Integer>>> 那就得循环new了 遭罪啊
    boolean[][] row = new boolean[9][9]; // 第几行 哪位数 true false
    boolean[][] col = new boolean[9][9]; // 第几列的哪位数
    // 第几个九宫格 三行 三列 九格 哪位数 true false
    boolean[][][] square = new boolean[3][3][9];

    // 存储还没有填上的位置
    private List<int[]> blank = new ArrayList<int[]>();

    // 当一个搜索已经搞定任务 让别的搜索提前结束
    private boolean finished = false;

    // 快捷地设置状态数组
    private void visited(int i, int j, int num, boolean isVisited){
        row[i][num] = col[j][num] = square[i / 3][j / 3][num] = isVisited;
        return;
    }
    // visited 三数组都没有true记录
    // 即都没有同行同列同格有相同数字 才认为is valided
    private boolean isValided(int i, int j, int num){
        return !row[i][num] && !col[j][num] && !square[i/3][j/3][num];
    }
    public void solveSudoku(char[][] board) {
        this.board = board;
        for(int i = 0 ; i < len ; ++i){
            for(int j = 0 ; j < len ; ++j){
                if(board[i][j] == '.') {
                    blank.add(new int[]{i, j});
                }
                else {
                    visited(i, j, board[i][j]-'0'-1, true);
                }
            }
        }
        dfs(0);
    }
    private void dfs(int depth){
        if(depth == blank.size()) {
            finished = true;
            return;
        }
        int[] curPoint = blank.get(depth); // 我们以 遍历空格的每一步作为回溯深度
        // 在num < 9 这边 用&&来实现!finished 是个好主意 比起再循环内部break优雅
        // 注意 0~8 代表 1-9 ！因为数组下标的关系
        for(int num = 0 ; num < 9 && !finished; ++num){
            if( isValided(curPoint[0], curPoint[1], num) ){
                visited(curPoint[0], curPoint[1], num, true);
                board[curPoint[0]][curPoint[1]] = (char) (num+'0'+1);
                dfs(depth+1);
                visited(curPoint[0], curPoint[1], num, false);
            }
        }
    }


    /**
     * 自写方法 纯暴力
     * @param board
     */
    public void solveSudoku1(char[][] board) {
        char[][] newBoard = board.clone();
        List<Integer[]> coordinate = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (newBoard[i][j] == '.') {
                    coordinate.add(new Integer[]{i,j});
                }
            }
        }
        board = fillAllNumber(board,coordinate,0);
    }

    public char[][] fillAllNumber(char[][] board,List<Integer[]> list,int index) {
        //填充当前坐标
        board = fillNumber(board,list.get(index)[0],list.get(index)[1]);
        //如果当前坐标填充结果为 .表示没有符合的数字 重回到上一位加1开始填数
        if (board[list.get(index)[0]][list.get(index)[1]] =='.') {
//            for (int i = 0; i <= index; i++) {
//                System.out.println(list.get(index)[0]);
//                System.out.println(list.get(index)[1]);
//                board[list.get(i)[0]][list.get(i)[1]] = '.';
//            }
            return fillAllNumber(board,list,--index);
        }
        //如果 填充有结果 并且还有下一个空位 继续下一个数字的填写
        if (index < list.size() -1){
            return fillAllNumber(board,list,++index);
        }
        //全部填充结束
        return board;
    }

    public char[][] fillNumber(char[][] board,int row,int column) {
        boolean con = false;
        System.out.println(++count);
        System.out.println("fillNumber 递归" + board[row][column]);
        if (board[row][column] != '.' && board[row][column] < '9') {
            board[row][column]++;
        } else if (board[row][column] == '.') {
            board[row][column] = '1';
        } else {
            board[row][column] = '.';
            //当前位置已经尝试到数字9还是没有满足条件的数字可填 返回
            return board;
        }

        boolean[] rows = new boolean[9];
        boolean[] columns = new boolean[9];
        boolean[] box = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (con) {
                break;
            }
            int number = 0;
            if (board[row][i] != '.') {
                number = board[row][i] -'1';
            }

            if (board[i][column] != '.') {
                number = board[i][column] -'1';
            }

            if (board[i/3][i%3] != '.') {
                number = board[i/3][i%3] - '1';
            }

            box[number] = true;
            columns[number] = true;
            rows[number] = true;
        }
        if (con) {
            return fillNumber(board,row,column);
        } else {
            return board;
        }
    }

    public char[][] fillNumber1(char[][] board,int row,int column) {
        boolean con = false;
        System.out.println(++count);
        System.out.println("fillNumber 递归" + board[row][column]);
        if (board[row][column] != '.' && board[row][column] < '9') {
            board[row][column]++;
        } else if (board[row][column] == '.') {
            board[row][column] = '1';
        } else {
            board[row][column] = '.';
            //当前位置已经尝试到数字9还是没有满足条件的数字可填 返回
            return board;
        }

        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            if (con) {
                break;
            }
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int number = board[i][j] -'1';
                    int boxNumber = j/3 + (i/3*3);
                    if (rows[i][number] || columns[j][number] || box[boxNumber][number]) {
                        con = true;
                        break;
                    }

                    columns[j][number] = true;
                    rows[i][number] = true;
                    box[boxNumber][number] = true;
                }
            }
        }
        if (con) {
            return fillNumber(board,row,column);
        } else {
            return board;
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
        System.out.println(target);
    }
}
