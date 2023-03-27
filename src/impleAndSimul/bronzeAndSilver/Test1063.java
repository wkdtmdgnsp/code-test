package impleAndSimul.bronzeAndSilver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        Position king = new Position(s.charAt(0), s.charAt(1) -'0');
        s = st.nextToken();
        Position stone = new Position(s.charAt(0), s.charAt(1) -'0');

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (matchPosition(king, stone, command) && stone.canMove(command)) {
                stone.move(command);
                king.move(command);
                continue;
            }
            if (!matchPosition(king, stone, command) && king.canMove(command)) {
                king.move(command);
            }
        }

        System.out.println(king.getPosition());
        System.out.println(stone.getPosition());
    }

    private static boolean matchPosition(Position king, Position stone, String command) {
        return king.nextPosition(command).getPosition().equals(stone.getPosition());
    }

    static class Position {
        private Character x;
        private int y;

        public Position(Character x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(String command) {
            switch (command) {
                case "R" : xPlus(); break;
                case "L" : xMinus(); break;
                case "B" : yMinus(); break;
                case "T" : yPlus(); break;
                case "RT" : xPlus(); yPlus(); break;
                case "LT" : xMinus(); yPlus(); break;
                case "RB" : xPlus(); yMinus(); break;
                case "LB" : xMinus(); yMinus(); break;
            }
        }

        public boolean canMove(String command) {
            Position nextPosition = nextPosition(command);

            if (nextPosition.x < 'A' || nextPosition.x > 'H') {
                return false;
            }
            if (nextPosition.y < 1 || nextPosition.y > 8) {
                return false;
            }

            return true;
        }

        public Position nextPosition(String command) {
            Position nextPosition = new Position(x, y);
            nextPosition.move(command);
            return nextPosition;
        }

        public String getPosition() {
            return String.valueOf(x) + String.valueOf(y);
        }

        private void xPlus() {
            x = (char)(x+1);
        }

        private void xMinus() {
            x = (char)(x-1);
        }

        private void yPlus() {
            y++;
        }

        private void yMinus() {
            y--;
        }
    }
}