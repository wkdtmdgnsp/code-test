package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 오픈채팅방
 */
public class Test8 {

    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        // 유저아이디를 키로 해서 닉네임 변경을 반영
        for (String s : record) {
            String[] s1 = s.split(" ");
            String command = s1[0];

            if (command.equals("Enter") || command.equals("Change")) {
                map.put(s1[1], s1[2]);
            }
        }

        // 메시지 처리
        for (String s : record) {
            String[] s1 = s.split(" ");
            String command = s1[0];

            if (command.equals("Enter")) {
                result.add(map.get(s1[1])+"님이 들어왔습니다.");
            }
            if (command.equals("Leave")) {
                result.add(map.get(s1[1])+"님이 나갔습니다.");
            }
        }

        return result.toArray(new String[result.size()]);
    }
}
