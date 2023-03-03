package test2;

import java.util.ArrayList;

/**
 * 영어 끝말잇기
 */
public class Test3 {
    private static ArrayList<String> list = new ArrayList<>();
    private static int[] answer = new int[2];
    private static int n;

    public int[] solution(int n, String[] words) {
        char end = words[0].charAt(0);
        this.n = n;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int num = i +1;

            if (list.contains(word)) {
                answerCal(num);
                break;
            }

            if (end != word.charAt(0)) {
                answerCal(num);
                break;
            }

            list.add(word);
            end = word.charAt(word.length() -1);
        }

        return answer;
    }

    private static void answerCal(int num) {
        if (num % n == 0) {
            answer[0] = n;
            answer[1] = num / n;
            return;
        }
        answer[0] = num % n;
        answer[1] = num / n +1;
    }
}
