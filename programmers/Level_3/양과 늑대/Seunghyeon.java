import java.util.*;

class Seunghyeon {
    Set<Integer>[] nodes;
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        nodes = new HashSet[info.length];

        for (int edge[]: edges) {
            int parent = edge[0];
            int child = edge[1];
            if (nodes[parent] == null) {
                nodes[parent] = new HashSet<>();
            }
            nodes[parent].add(child);
        }

        dfs(0, 0, 0, new HashSet<>(), info);

        return answer;
    }

    void dfs(int cur, int sheep, int wolf, Set<Integer> visits, int[] info) {
        sheep += info[cur] ^ 1;
        wolf += info[cur];
        if (sheep <= wolf) return;
        answer = Math.max(sheep, answer);

        Set<Integer> newVisits = new HashSet<>();
        newVisits.addAll(visits);
        newVisits.remove(Integer.valueOf(cur));

        if (nodes[cur] != null) {
            newVisits.addAll(nodes[cur]);
        }

        for (int visit: newVisits) {
            dfs(visit, sheep, wolf, newVisits, info);
        }
    }
}