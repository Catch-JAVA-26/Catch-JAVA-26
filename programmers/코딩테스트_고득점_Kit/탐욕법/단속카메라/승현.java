import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int loc = -30001;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        for (int[] route: routes) {
            if (loc < route[0]) {
                loc = route[1];
                answer++;
            }
        }

        return answer;
    }
}