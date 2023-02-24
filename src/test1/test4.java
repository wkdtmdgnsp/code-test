package test1;

import java.util.HashMap;

/**
 * [카카오 인턴] 키패드 누르기
 */
public class test4 {

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        Hand leftHand = new Hand(10);
        Hand rightHand = new Hand(11);
        Keypad keypad = new Keypad();

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                leftHand.move(number);
                sb.append("L");
                continue;
            }
            if (number == 3 || number == 6 || number == 9) {
                rightHand.move(number);
                sb.append("R");
                continue;
            }
            sb.append(keypad.move(leftHand, rightHand, number, hand));
        }

        return sb.toString();
    }

    static class Hand {
        private int number;

        public Hand(int number) {
            this.number = number;
        }

        public void move(int number) {
            this.number = number;
        }
    }

    static class Keypad {
        private HashMap<Integer, Position> keyNumber = new HashMap<>();

        public Keypad() {
            keyNumber.put(1, new Position(0, 0));
            keyNumber.put(2, new Position(0, 1));
            keyNumber.put(3, new Position(0, 2));
            keyNumber.put(4, new Position(1, 0));
            keyNumber.put(5, new Position(1, 1));
            keyNumber.put(6, new Position(1, 2));
            keyNumber.put(7, new Position(2, 0));
            keyNumber.put(8, new Position(2, 1));
            keyNumber.put(9, new Position(2, 2));
            keyNumber.put(10, new Position(3, 0));
            keyNumber.put(0, new Position(3, 1));
            keyNumber.put(11, new Position(3, 2));
        }

        public String move(Hand leftHand, Hand rightHand, int number, String hand) {
            Position target = keyNumber.get(number);
            int left = keyNumber.get(leftHand.number).positionRange(target);
            int right = keyNumber.get(rightHand.number).positionRange(target);

            if (left < right) {
                leftHand.move(number);
                return "L";
            }
            if (left > right) {
                rightHand.move(number);
                return "R";
            }
            if (hand.equals("left")) {
                leftHand.move(number);
                return "L";
            }
            rightHand.move(number);
            return "R";
        }
    }

    static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int positionRange(Position target) {
            return Math.abs(this.x - target.x) + Math.abs(this.y - target.y);
        }
    }


}
