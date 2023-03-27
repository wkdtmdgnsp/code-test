package impleAndSimul.bronzeAndSilver;

import java.util.Scanner;

public class Test2980 {
    /**
     * 신호등 개수N, 도로의 길이 L
     * 신호등 위치 D, 빨간불 시간 R, 초록불 시간 G
     * 끝까지 이동하는 시간 구하기
     * 신호등은 D가 증가하는 순서로 주어지며,(정렬 안해도됨)
     * 같은 위치에 있는 신호등이 두 개 이상 있는 경우는 없다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int truck = 0;
        int time = 0;

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            int r = sc.nextInt();
            int g = sc.nextInt();
            time += d -truck;
            truck = d;

            int gap = time % (r +g);
            if (gap < r) {
                time += r - gap;
            }
        }

        time += l - truck;
        System.out.print(time);
    }
}