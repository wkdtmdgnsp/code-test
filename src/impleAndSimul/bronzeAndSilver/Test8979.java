package impleAndSimul.bronzeAndSilver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test8979 {

    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Country country = new Country(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            countries.add(country);
        }

        List<Country> collect = countries.stream()
                .sorted(Comparator.comparing(Country::getGold)
                        .thenComparing(Country::getSilver)
                        .thenComparing(Country::getCopper)
                        .reversed())
                .collect(Collectors.toList());

        getRank(collect);

        for (Country country : collect) {
            if (country.getName() == s) {
                System.out.print(country.rank);
                break;
            }
        }
    }

    private static void getRank(List<Country> collect) {
        int rank = 1;
        for (int i = 1; i < collect.size(); i++) {
            Country prevCountry = collect.get(i-1);
            Country currentCountry = collect.get(i);

            if (prevCountry.equals(currentCountry)) {
                currentCountry.rank = prevCountry.rank;
                rank++;
                continue;
            }

            currentCountry.rank += rank;
            rank++;
        }
    }

    static class Country {
        private int name;
        private int gold;
        private int silver;
        private int copper;
        private int rank = 1;

        public Country(int name, int gold, int silver, int copper) {
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.copper = copper;
        }

        public int getName() {
            return name;
        }

        public int getGold() {
            return gold;
        }

        public int getSilver() {
            return silver;
        }

        public int getCopper() {
            return copper;
        }

        public boolean equals(Country country) {
            return gold == country.gold && silver == country.silver && copper == country.getCopper();
        }
    }
}
