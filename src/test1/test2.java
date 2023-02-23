package test1;

import java.util.*;

/**
 * 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
 * 로또의 최고 순위와 최저 순위
 */
public class test2 {

    public int[] solution(int[] lottos, int[] win_nums) {
        Lotto user = new Lotto(lottos);
        Lotto win = new Lotto(win_nums);

        int matchCount = user.matchCount(win);

        HashMap<Integer, Integer> score = score();

        int min = score.getOrDefault(matchCount, 6);
        int max = score.getOrDefault(matchCount +user.numberZero(), 6);

        int[] answer = {max, min};
        return answer;
    }

    public HashMap<Integer, Integer> score() {
        HashMap<Integer, Integer> score = new HashMap<>();
        int rank = 5;
        for (int i = 2; i <= 6; i++) {
            score.put(i, rank--);
        }
        return score;
    }

   class Lotto {
        private List<Integer> numbers = new ArrayList<>();

        Lotto(int [] nums) {
            for (int num : nums) {
                numbers.add(num);
            }
        }

        public int matchCount(Lotto lotto) {
            int count = 0;
            for (Integer number : numbers) {
                if (lotto.numbers.contains(number)) {
                    count++;
                }
            }
            return count;
        }

        public int numberZero() {
            return Collections.frequency(numbers, 0);
        }
    }
}
