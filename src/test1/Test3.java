package test1;

/**
 * 캐릭터의 좌표
 */
public class Test3 {

    public int[] solution(String[] keyinput, int[] board) {
        User user = new User(board);
        user.play(keyinput);

        int[] answer = {user.position.x, user.position.y};
        return answer;
    }

    class User {
        private Position position;
        private Move move;

        User(int[] board) {
            position = new Position(0, 0, board);
            move = new Move();
        }

        public void play(String[] keyinput) {
            for (String key : keyinput) {
                if (key.equals("left") || key.equals("right")) {
                    move.moveX(key, position);
                    continue;
                }
                move.moveY(key, position);
            }
        }
    }

    class Position {
        private int x;
        private int y;
        private int minX;
        private int minY;
        private int maxX;
        private int maxY;

        Position(int x, int y, int[] board) {
            this.x = x;
            this.y = y;
            maxX = board[0] / 2;
            maxY = board[1] / 2;
            minX = -maxX;
            minY = -maxY;
        }

        public void leftX() {
            if (x > minX) {
                x -= 1;
            }
        }

        public void rightX() {
            if (x < maxX) {
                x += 1;
            }
        }

        public void upY() {
            if (y < maxY) {
                y += 1;
            }
        }

        public void downY() {
            if (y > minY) {
                y -= 1;
            }
        }
    }

    class Move {
        Move() {}

        public void moveX(String key, Position position) {
            if (key.equals("left")) {
                position.leftX();
                return;
            }
            position.rightX();
        }

        public void moveY(String key, Position position) {
            if (key.equals("up")) {
                position.upY();
                return;
            }
            position.downY();
        }
    }
}
