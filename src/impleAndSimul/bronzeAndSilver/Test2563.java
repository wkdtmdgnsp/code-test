package impleAndSimul.bronzeAndSilver;

import java.util.Scanner;

public class Test2563 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean square[][] = new boolean[101][101];
        int sum = 0;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            sum += addColored(square, x, y);
        }

        System.out.print(sum);
    }

    private static int addColored(boolean[][] square, int x, int y) {
        int sum = 0;
        for (int j = x; j < x + 10; j++) {
            for (int k = y; k < y + 10; k++) {
                if (!square[j][k]) {
                    square[j][k] = true;
                    sum++;
                }
            }
        }
        return sum;
    }
}
