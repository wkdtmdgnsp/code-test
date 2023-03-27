package impleAndSimul.bronzeAndSilver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test3048 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        List<Character> n1 = new ArrayList<>();
        List<Character> n2 = new ArrayList<>();
        List<Character> n = new ArrayList<>();
        sc.nextInt();
        sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        int t = sc.nextInt();

        for (int i = a.length() -1; i >= 0; i--) {
            n1.add(a.charAt(i));
            n.add(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            n2.add(b.charAt(i));
            n.add(b.charAt(i));
        }

        for (int i = 0; i < t; i++) {
            nSwap(n1, n2, n);
        }

        for (Character character : n) {
            sb.append(character);
        }

        System.out.println(sb);
    }

    private static void nSwap(List<Character> n1, List<Character> n2, List<Character> n) {
        for (int j = 0; j < n.size() -1; j++) {
            if (n1.contains(n.get(j)) && n2.contains(n.get(j+1))) {
                Collections.swap(n, j, j+1);
                j++;
            }
        }
    }
}
