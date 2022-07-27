import java.util.Map;
import java.util.HashMap;

class Seunghyeon {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> hm = new HashMap<>();

        for (String[] cloth: clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1], 0) + 1);
        }

        for (int num: hm.values()) {
            answer *= (num + 1);
        }

        answer--;

        return answer;
    }
}