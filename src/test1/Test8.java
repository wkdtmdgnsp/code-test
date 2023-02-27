package test1;

import java.util.HashMap;

/**
 * 2022 KAKAO TECH INTERNSHIP
 * 성격 유형 검사하기
 */
public class Test8 {
    static HashMap<Character, Integer> category = new HashMap<>();
    static HashMap<Integer, Integer> score = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        categoryInit();
        scoreInit();
        scoreRun(survey, choices);

        String answer = resultCal();

        return answer;
    }

    private static String resultCal() {
        StringBuilder sb = new StringBuilder();
        sb.append(result1());
        sb.append(result2());
        sb.append(result3());
        sb.append(result4());
        return sb.toString();
    }

    private static String result1() {
        if (category.get('R') < category.get('T')) {
            return "T";
        }
        return "R";
    }

    private static String result2() {
        if (category.get('C') < category.get('F')) {
            return "F";
        }
        return "C";
    }

    private static String result3() {
        if (category.get('J') < category.get('M')) {
            return "M";
        }
        return "J";
    }

    private static String result4() {
        if (category.get('A') < category.get('N')) {
            return "N";
        }
        return "A";
    }

    private static void scoreRun(String[] survey, int[] choices) {
        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            if (choice < 4) {
                char c = survey[i].charAt(0);
                scoreAdd(choice, c);
            }
            if (choice > 4) {
                char c = survey[i].charAt(1);
                scoreAdd(choice, c);
            }
        }
    }

    private static void scoreAdd(int choice, char c) {
        category.put(c, category.get(c) +score.get(choice));
    }

    private void scoreInit() {
        score.put(1, 3);
        score.put(2, 2);
        score.put(3, 1);
        score.put(4, 0);
        score.put(5, 1);
        score.put(6, 2);
        score.put(7, 3);
    }

    private void categoryInit() {
        category.put('R', 0);
        category.put('T', 0);
        category.put('C', 0);
        category.put('F', 0);
        category.put('J', 0);
        category.put('M', 0);
        category.put('A', 0);
        category.put('N', 0);
    }
}
