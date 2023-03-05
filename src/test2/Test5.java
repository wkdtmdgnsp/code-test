package test2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;

/**
 * 튜플
 */
public class Test5 {

    public int[] solution(String s) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        s = s.substring(2, s.length()-2);
        String[] split = s.split("},\\{");

        String[] result = Arrays.stream(split)
                .sorted(Comparator.comparing(s1 -> s1.length()))
                .toArray(String[]::new);

        for (String s1 : result) {
            String[] split1 = s1.split(",");
            for (String s2 : split1) {
                set.add(Integer.parseInt(s2));
            }
        }

        int[] answer = new int[set.size()];
        int idx = 0;

        for (Integer value : set) {
            answer[idx] = value;
            idx++;
        }

        return answer;
    }
}
