package impleAndSimul.gold;

import java.util.Scanner;

public class Test14500 {

    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] paper;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        paper= new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, paper[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.print(max);
    }

    static void dfs(int x, int y, int sum, int count) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int curX = x +dx[i];
            int curY = y +dy[i];

            if (isOutRange(curX, curY)) {
                continue;
            }

            if (!visited[curX][curY]) {
                if (count == 2) {
                    visited[curX][curY] = true;
                    dfs(x, y, sum +paper[curX][curY], count+1);
                    visited[curX][curY] = false;
                }

                visited[curX][curY] = true;
                dfs(curX, curY, sum +paper[curX][curY], count+1);
                visited[curX][curY] = false;
            }
        }
    }

    private static boolean isOutRange(int curX, int curY) {
        return curX < 0 || curX >= n || curY < 0 || curY >= m;
    }
}
