package test1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 2019 KAKAO BLIND RECRUITMENT - 실패율
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 */
public class Test1 {
    public int[] solution(int N, int[] stages) {
        List<Stage> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            answer.add(new Stage(i, stages));
        }

        return answer.stream()
                .sorted(Comparator.comparing(Stage::getFailRate).reversed())
                .mapToInt(s -> s.num)
                .toArray();
    }

    class Stage {
        private int num;
        private double failRate;

        public Stage(int num, int[] stages) {
            this.num = num;
            failRateCal(stages);
        }

        public double getFailRate() {
            return failRate;
        }

        private void failRateCal(int[] stages) {
            int noClear = 0;
            int clear = 0;
            for (int i = 0; i < stages.length; i++) {
                if (num == stages[i]) {
                    noClear++;
                }
                if (num <= stages[i]) {
                    clear++;
                }
            }
            if (noClear == 0) {
                failRate = 0;
                return;
            }
            failRate = (double) noClear / clear;
        }
    }
}
