import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int n=1; n<=Math.sqrt(yellow); n++) {
            if (yellow % n == 0) {
                if ((yellow / n + 2) * 2 + (n * 2) == brown) {
                    answer[0] = yellow / n + 2;
                    answer[1] = n + 2;
                    break;
                }
            }
        }

        return answer;
    }
}