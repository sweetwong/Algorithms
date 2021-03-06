package leet_code.important;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 提示：
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。（引用自 百度百科 - 皇后 ）
 *
 * @see classical.NQueens
 */
class Item51_N皇后_solution {

    // 竖排被占登记，用于判断是否能够被竖排攻击
    int rows[];

    // 主对角线, "\"方向的对角线(矩阵定义), 满足: row - column = const
    // 每次输入row - column, 得到一个const, 来判断在哪一个对角线
    int main[];

    // 次对角线, "/"方向的对角线(矩阵定义), 满足: row + column = const
    // 每次输入row + column, 得到一个const, 来判断在哪一个对角线
    int anti[];

    int n;

    // 皇后的位置, queens[row] = col, 第row的皇后在col列
    int queens[];

    List<List<String>> res = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        main = new int[2 * n - 1];
        anti = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return res;
    }


    /**
     * 此处输入为row, 说明是按行回溯
     */
    public void backtrack(int row) {

        // 在第row行, 以0为起点
        for (int col = 0; col < n; col++) {

            // 假如此行一直不成功, 这个深度的backtrack就运行结束
            // 执行上一个深度的回溯操作
            if (isNotUnderAttack(row, col)) {

                // 放置皇后
                placeQueen(row, col);

                if (row + 1 == n) {
                    // 如果当前行是最后一行且放置了皇后, 说明已经完成任务, 添加解
                    addSolution();
                } else {
                    // 如果当前行不是最后一行且放置了皇后, 遍历下一行, 在此处递归
                    backtrack(row + 1);
                }

                // 回溯, 移除皇后
                removeQueen(row, col);
            }

        }
    }

    /**
     * 判断该位置是否会被攻击
     */
    public boolean isNotUnderAttack(int row, int col) {
        // main: row - col = const, 加上常数 n - 1 是为了防止出现负数下标, 例如 row = 0, col = 3
        // anti: row + col = const
        int res = rows[col] + main[row - col + n - 1] + anti[row + col];
        return (res == 0) ? true : false;
    }

    /**
     * 将皇后放入该位置
     */
    public void placeQueen(int row, int col) {
        queens[row] = col;   // 将皇后位置放入
        rows[col] = 1;   // 竖排攻击位置
        main[row - col + n - 1] = 1;  // "从左下到右上对角线" 攻击位置
        anti[row + col] = 1;   // "从左上到右下对角线" 攻击位置
    }

    /**
     * 回溯皇后位置
     */
    public void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        main[row - col + n - 1] = 0;
        anti[row + col] = 0;
    }

    /**
     * 将满足条件的皇后位置放入output中
     */
    public void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for (int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        res.add(solution);
    }

}
