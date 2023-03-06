package test2;

import java.util.ArrayList;
import java.util.List;

public class Test6 {
    /**
     * 뉴스 클러스터링
     */
    public int solution(String str1, String str2) {
        List<String> letter1 = new ArrayList<>();
        List<String> letter2 = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        addStringList(str1, letter1);
        addStringList(str2, letter2);

        if (letter1.size() == 0 && letter2.size() == 0) {
            return 65536;
        }

        addIntersection(letter1, letter2, intersection);

        int unionSize = letter1.size() +letter2.size() +intersection.size();

        return (int) ((double) intersection.size() / unionSize * 65536);
    }

    private static void addIntersection(List<String> letter1, List<String> letter2, List<String> intersection) {
        for (String s1 : letter1) {
            for (String s2 : letter2) {
                if (s1.equals(s2)) {
                    intersection.add(s1);
                    letter2.remove(s2);
                    break;
                }
            }
        }

        for (String s : intersection) {
            letter1.remove(s);
        }
    }

    private static void addStringList(String target, List<String> letter) {
        String str = "";

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            str += c;
            if (str.length() == 2) {
                boolean isAlpha = str.chars().allMatch(Character::isAlphabetic);
                if (isAlpha) {
                    letter.add(str.toLowerCase());
                }
                str = String.valueOf(c);
            }
        }
    }
}
