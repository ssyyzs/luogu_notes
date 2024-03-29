package com.ssy.luogu.dp;

import java.util.Scanner;

/**
 * <p>{@link <a href="https://www.luogu.com.cn/problem/P1049">装箱</a>}</p>.
 *
 * @author ssyyzs
 * @since 2024-03-29
 */
public class MainP1049 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            int v = in.nextInt();
            int n = in.nextInt();
            int[] vArr = new int[n];
            for (int i = 0; i < n; i++) {
                vArr[i] = in.nextInt();
            }
            int[] dp = new int[v + 1];
            for (int i = 0; i < n; i++) {
                for (int j = v; j >= vArr[i]; j--) { // 每个实例只能加入一次，从上往下减。 不限次数从下往上。
                    dp[j] = Math.max(dp[j - vArr[i]] + vArr[i], dp[j]);
                }
            }
            System.out.println(v - dp[v]);
        }
    }
}
