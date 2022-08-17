import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] solvers = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] solves = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < solvers.length; j++) {
                if (solvers[j][i % solvers[j].length] == answers[i]) solves[j]++;
            }
        }

        int maxSolve = Math.max(Math.max(solves[0], solves[1]), solves[2]);
        List<Integer> bestSolvers = new ArrayList<>();

        for (int i = 0; i < solves.length; i++) {
            if (maxSolve == solves[i]) {bestSolvers.add(i + 1);}
        }

        return bestSolvers.stream().mapToInt(i -> i).toArray();
    }
}
