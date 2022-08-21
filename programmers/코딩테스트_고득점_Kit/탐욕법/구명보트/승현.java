import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] heavy = Arrays.stream(people).boxed().toArray(Integer[]::new);
        int len = heavy.length;
        int heavyOne, lightIdx = len - 1;

        Arrays.sort(heavy, Collections.reverseOrder());

        for (int heavyIdx = 0; heavyIdx <= lightIdx; heavyIdx++) {
            heavyOne = heavy[heavyIdx];

            if (heavyOne <= limit / 2) {
                answer += Math.ceil((lightIdx + 1 - heavyIdx) / 2.0);
                break;
            } else if (heavy[lightIdx] + heavy[lightIdx - 1] > limit) {
                answer += lightIdx + 1 - heavyIdx;
                break;
            }

            answer++;
            if (heavyOne + heavy[lightIdx] <= limit) {
                lightIdx--;
            }
        }

        return answer;
    }
}