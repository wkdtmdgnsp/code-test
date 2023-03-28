package impleAndSimul.gold;

import java.util.Scanner;

public class Test14890 {

    static int n;
    static int l;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        map = new int[n][n];
        int count = 0;

        mapInput(sc);

        for (int i = 0; i < n; i++) {
            if (calRow(i)) {
                count++;
            }
            if (calCol(i)) {
                count++;
            }
        }

        System.out.print(count);
    }

    private static void mapInput(Scanner sc) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }

    private static boolean calRow(int row) {
        boolean[] isIncline = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            if (notHighRow(row, i)) {
                return false;
            }

            if (map[row][i] < map[row][i +1]) {
                if (isHigh(isIncline, i)) return false;
            }

            if (map[row][i] > map[row][i +1]) {
                if (isLow(isIncline, i)) return false;
            }
        }

        return true;
    }

    private static boolean calCol(int col) {
        boolean[] isIncline = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            if (notHighCol(i, col)) {
                return false;
            }

            if (map[i][col] < map[i +1][col]) {
                if (isHigh(isIncline, i)) return false;
            }

            if (map[i][col] > map[i +1][col]) {
                if (isLow(isIncline, i)) return false;
            }
        }

        return true;
    }

    private static boolean notHighRow(int row, int i) {
        return Math.abs(map[row][i] - map[row][i + 1]) > 1;
    }

    private static boolean notHighCol(int i, int col) {
        return Math.abs(map[i][col] - map[i +1][col]) > 1;
    }

    private static boolean isHigh(boolean[] isIncline, int i) {
        for (int j = 0; j < l; j++) {
            if (i - j < 0 || isIncline[i -j]) {
                return true;
            }
            isIncline[i -j] = true;
        }
        return false;
    }

    private static boolean isLow(boolean[] isIncline, int i) {
        for (int j = 1; j <= l; j++) {
            if (i + j >= n || isIncline[i +j]) {
                return true;
            }
            isIncline[i +j] = true;
        }
        return false;
    }
}
