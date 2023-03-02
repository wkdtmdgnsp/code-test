package test2;

public class Test1 {
    /**
     * 월간 코드 챌린지 시즌1
     * 이진 변환 반복하기
     */
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int beforeLength = s.length();
            s = s.replaceAll("0", "");
            answer[1] += beforeLength - s.length();
            answer[0] += 1;
            s = Integer.toBinaryString(s.length());
        }

        return answer;
    }
}
