package leet_code;

/**
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 *
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 *
 * 给出两个矩形，判断它们是否重叠并返回结果。
 *
 * 示例 1：
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 *
 * 提示：
 * 1. 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
 * 2. 矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 * 3. x 轴默认指向右，y 轴默认指向上。
 * 4. 你可以仅考虑矩形是正放的情况。
 */
public class Item836_矩形重叠 {

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] x1 = {rec1[0], rec1[2]};
        int[] x2 = {rec2[0], rec2[2]};
        int[] y1 = {rec1[1], rec1[3]};
        int[] y2 = {rec2[1], rec2[3]};

        if (x1[1] < x2[0] || x1[0] > x2[1]) {
            return false;
        }

        if (y1[1] < y2[0] || y1[0] > y2[1]) {
            return false;
        }

        int[] intersectX = {Math.max(x1[0], x2[0]), Math.min(x1[1], x2[1])};
        int[] intersectY = {Math.max(y1[0], y2[0]), Math.min(y1[1], y2[1])};

        return intersectX[1] - intersectX[0] > 0 && intersectY[1] - intersectY[0] > 0;
    }

    public static void main(String[] args) {
        int[] rec1 = {7, 8, 13, 15};
        int[] rec2 = {10, 8, 12, 20};
        System.out.println(isRectangleOverlap(rec1, rec2));
    }

}
