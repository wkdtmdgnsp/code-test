package doit;

import java.util.Scanner;

public class Test2884 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int sum = (h *60 +m) -45;

        if (sum < 0) {
            sum = 60 * 24 +sum;
        }

        h = sum / 60;
        m = sum % 60;

        System.out.print(h +" " +m);
    }
}
