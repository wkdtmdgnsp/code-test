package doit;

import java.util.Arrays;
import java.util.Scanner;

public class Test1546 {
    /**
     * 평균
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int m = 0;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        m = nums[n-1];

        for (int i = 0; i < n; i++) {
            sum += (double) nums[i] / m * 100;
        }

        System.out.println(sum / n);
    }
}
