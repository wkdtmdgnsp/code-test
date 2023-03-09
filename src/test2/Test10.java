package test2;

/**
 * k진수에서 소수 개수 구하기
 */
public class Test10 {

    public int solution(int n, int k) {
        int answer = 0;
        char[] chars = Integer.toString(n, k).toCharArray();
        StringBuilder s = new StringBuilder();

        for (char ch : chars) {
            if (ch == '0' && s.length() != 0) {
                if (isPrime(Long.valueOf(s.toString()))) {
                    answer++;
                }
                s.setLength(0);
                continue;
            }
            s.append(ch);
        }

        if (isPrime(Long.valueOf(s.toString()))) {
            answer++;
        }

        return answer;
    }

    boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
