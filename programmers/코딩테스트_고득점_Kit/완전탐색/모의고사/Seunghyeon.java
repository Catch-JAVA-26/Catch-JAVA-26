import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] cases = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            int num = answers[i];
            for (int j=0; j<3; j++) {
                if (num == cases[j][i % cases[j].length]) {
                    scores[j]++;
                }
            }
        }

        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));

        List<Integer> ansList = new ArrayList<>();
        for (int i=0; i<3; i++) {
            if (max == scores[i]) {
                ansList.add(i+1);
            }
        }

        int[] answer = new int[ansList.size()];
        int index = 0;
        for (int n: ansList) {
            answer[index++] = n;
        }

        return answer;
    }
}