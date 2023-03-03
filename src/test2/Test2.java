package test2;

import java.util.Stack;

/**
 * 짝지어 제거하기
 */
public class Test2 {

    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }

        if (stack.empty()) {
            answer = 1;
        }

        return answer;
    }
}
