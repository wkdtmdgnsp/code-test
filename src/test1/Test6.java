package test1;

import java.util.Stack;

/**
 * 2019 카카오 개발자 겨울 인턴십
 * 크레인 인형뽑기 게임
 */
public class Test6 {
    /**
     * 화면에서 위에부터 인형을 꺼낸다
     * 꺼낸 인형을 바구니에 저장하고 그 위치를 0으로 만들어 빈자리로 바꾼다.
     * 바구니에 2개가 동일하면 인형을 터트리고 그 숫자 2개를 더한다.
     */
    static int answer = 0;
    static Stack<Integer> basket = new Stack<>();

    public int solution(int[][] board, int[] moves) {

        for (int i = 0; i < moves.length; i++) {
            int boardIdx = moves[i] -1;
            dollPush(board, boardIdx);
        }
        
        return answer;
    }

    private static void dollPush(int[][] board, int boardIdx) {
        for (int j = 0; j < board.length; j++) {
            if (board[j][boardIdx] != 0) {
                if (dollDestroy(board, boardIdx, j))  {
                    break;
                }
                basket.push(board[j][boardIdx]);
                board[j][boardIdx] = 0;
                break;
            }
        }
    }

    private static boolean dollDestroy(int[][] board, int boardIdx, int j) {
        if (!basket.empty() && basket.peek() == board[j][boardIdx]) {
            basket.pop();
            answer += 2;
            board[j][boardIdx] = 0;
            return true;
        }
        return false;
    }
}
