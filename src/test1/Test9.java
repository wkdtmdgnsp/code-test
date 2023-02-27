package test1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 2023 KAKAO BLIND RECRUITMENT
 * 개인정보 수집 유효기간
 */
public class Test9 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> result = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date_today = LocalDate.parse(today, formatter).plusDays(1);

        HashMap<String, Integer> term = getTerm(terms);

        int index = 1;
        for (String privacy : privacies) {
            String month = getMonth(privacy);
            boolean after = LocalDate.parse(privacy.substring(0, privacy.indexOf(" ")), formatter)
                    .plusMonths(term.get(month))
                    .isBefore(date_today);
            if (after) {
                result.add(index);
            }
            index++;
        }


        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private static HashMap<String, Integer> getTerm(String[] terms) {
        HashMap<String, Integer> term = new HashMap<>();
        for (String s : terms) {
            term.put(s.substring(0, 1), Integer.parseInt(s.substring(s.indexOf(" ")+1)));
        }
        return term;
    }

    private static String getMonth(String privacy) {
        return privacy.substring(privacy.indexOf(" ") + 1);
    }
}
