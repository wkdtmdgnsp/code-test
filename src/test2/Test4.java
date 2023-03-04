package test2;

public class Test4 {
    /**
     * [1차] 캐시
     */
    private static String[] caches;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        caches = new String[cacheSize];

        for (String city : cities) {
            int idx = indexOf(city);

            if (idx == -1) {
                newCache(cacheSize, city);
                answer += 5;
                continue;
            }

            updateCache(idx);
            answer += 1;
        }

        return answer;
    }

    private static int indexOf(String city) {
        int idx = -1;
        for (int i = 0; i < caches.length; i++) {
            if (caches[i] != null && caches[i].equalsIgnoreCase(city)) {
                return i;
            }
        }
        return idx;
    }

    private static void newCache(int cacheSize, String city) {
        for (int i = cacheSize -1; i > 0; i--) {
            caches[i] = caches[i-1];
        }
        caches[0] = city;
    }

    private static void updateCache(int idx) {
        String cache = caches[idx];
        for (int i = idx; i > 0; i--) {
            caches[i] = caches[i-1];
        }
        caches[0] = cache;
    }
}
