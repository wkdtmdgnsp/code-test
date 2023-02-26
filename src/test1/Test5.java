package test1;

import java.util.ArrayList;
import java.util.List;

/**
 * Summer/Winter Coding(~2018)
 * 소수 만들기
 */
public class Test5 {
    /**
     * 배열의 3개의 숫자의 합 구하기
     * 소수인지 판별
     * 카운트 더하기
     */
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> numSum = getNumberSum(nums);

        for (Integer num : numSum) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isPrime(Integer num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getNumberSum(int[] nums) {
        List<Integer> numSum = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    numSum.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        return numSum;
    }
}
