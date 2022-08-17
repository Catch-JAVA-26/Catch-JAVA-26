class Solution {
    static int answer;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, 0);

        return answer;
    }

    public void dfs(int hp, int[][] dungeons, int idx, int cnt){
        if (idx == dungeons.length){
            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = 0; i < dungeons.length; i++){
            if (visited[i] || dungeons[i][0] > hp) continue;

            visited[i] = true;
            dfs(hp - dungeons[i][1], dungeons, idx + 1, cnt + 1);
            visited[i] = false;
        }
    }
}
