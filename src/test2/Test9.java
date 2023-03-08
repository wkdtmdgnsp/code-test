package test2;

/**
 * [3차] n진수 게임
 */
public class Test9 {

    public String solution(int n, int t, int m, int p) {
        StringBuilder conversion = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < t * m; i++) {
            conversion.append(Integer.toString(i, n));
        }

        for (int i = p-1; answer.length() < t; i+=m) {
            answer.append(conversion.charAt(i));
        }

        return answer.toString().toUpperCase();
    }
}
