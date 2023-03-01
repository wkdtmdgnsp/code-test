package test1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 2022 KAKAO BLIND RECRUITMENT
 * 신고 결과 받기
 */
public class Test10 {

    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> reports = getReports(report);
        HashMap<String, Integer> reportCount = new HashMap<>();
        getCount(reports, reportCount);

        return Arrays.stream(id_list)
                .map(user -> {
                    String id = user;
                    return reports.stream()
                            .filter(s -> s.startsWith(id + " "))
                            .filter(s -> reportCount.getOrDefault(s.split(" ")[1], 0) >= k)
                            .count();
                }).mapToInt(Long::intValue).toArray();
    }

    private static List<String> getReports(String[] report) {
        return Arrays.stream(report)
                .distinct()
                .collect(toList());
    }

    private static void getCount(List<String> reports, HashMap<String, Integer> reportCount) {
        for (String reportUser : reports) {
            String user = reportUser.split(" ")[1];
            reportCount.put(user, reportCount.getOrDefault(user, 0) +1);
        }
    }

}
