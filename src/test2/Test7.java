package test2;

import java.util.ArrayList;
import java.util.List;

public class Test7 {
    /**
     * 스킬트리
     */
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> skillOrder = new ArrayList<>();

        for (int i = 0; i < skill.length(); i++) {
            skillOrder.add(skill.charAt(i));
        }

        for (String skillTree : skill_trees) {
            if (isPossibleSkill(skillOrder, skillTree)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPossibleSkill(List<Character> skillOrder, String skillTree) {
        int idx = 0;
        for (int i = 0; i < skillTree.length(); i++) {
            char currentSkill = skillTree.charAt(i);
            if (skillOrder.contains(currentSkill)) {
                if(skillOrder.get(idx) != currentSkill) {
                    return  false;
                }
                idx++;
            }
        }
        return true;
    }
}
