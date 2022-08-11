import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        boolean[] visited = new boolean[dungeons.length];

        for (int i=0; i<dungeons.length; i++) {
            answer = Math.max(answer, dfs(visited, dungeons, k, i));
        }

        return answer;
    }

    public int dfs(boolean[] visited, int[][] dungeons, int k, int n) {
        if (visited[n] || k < dungeons[n][0]) {
            return 0;
        }

        int cnt = 0;

        visited[n] = true;
        k -= dungeons[n][1];

        for (int i=0; i<dungeons.length; i++) {
            cnt = Math.max(cnt, dfs(visited, dungeons, k, i));
        }

        visited[n] = false;
        return cnt + 1;
    }
}