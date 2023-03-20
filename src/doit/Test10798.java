package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test10798 {

    public static void main(String[] args) throws IOException {
        char chars[][] = new char[5][15];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int max = 0;

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            max = Math.max(max, s.length());
            for (int j = 0; j < s.length(); j++) {
                chars[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (chars[j][i] != '\0') {
                    sb.append(chars[j][i]);
                }
            }
        }

        System.out.println(sb);
    }
}
