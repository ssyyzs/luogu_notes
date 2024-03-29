package com.ssy.luogu.dp;

import java.util.Scanner;

/**
 * {@link <a href="https://www.luogu.com.cn/problem/P1002">过河卒</a>}
 *
 * @author ssyyzs
 * @since 2024-03-29
 */
public class MainP10002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int endRow = in.nextInt();
        int endCol = in.nextInt();
        int horseRow = in.nextInt();
        int horseCol = in.nextInt();
        long[][] dp = new long[endRow + 1][endCol + 1]; // 到达每个点的路径条数
        dp[0][0] = 1;
        dp[horseRow][horseCol] = -1;
        int[][] horseControl = new int[][]{{-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};
        for (int[] ints : horseControl) {
            int row = horseRow + ints[0];
            int col = horseCol + ints[1];
            if (row >= 0 && row <= endRow && col >= 0 && col <= endCol) {
                dp[row][col] = -1;
            }
        }
        for (int i = 0; i <= endRow; i++) {
            for (int j = 0; j <= endCol; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                if (j + 1 <= endCol && dp[i][j + 1] != -1) {
                    dp[i][j + 1] += dp[i][j];
                }
                if (i + 1 <= endRow && dp[i + 1][j] != -1) {
                    dp[i + 1][j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[endRow][endCol]);
        in.close();
    }
}
