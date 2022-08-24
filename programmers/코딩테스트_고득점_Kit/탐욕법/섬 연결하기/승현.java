import java.util.*;

class Solution {
    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for (int i=0; i<n; i++) {
            parent[i] = i;
        }

        for (int[] cost: costs) {
            if (findParent(cost[0]) != findParent(cost[1])) {
                unionParent(cost[0], cost[1]);
                answer += cost[2];
            }
        }

        return answer;
    }

    int findParent(int n) {
        if (parent[n] != n)
            parent[n] = findParent(parent[n]);
        return parent[n];
    }

    void unionParent(int n, int m) {
        n = findParent(n);
        m = findParent(m);
        if (n < m) {
            parent[n] = m;
        } else {
            parent[m] = n;
        }
    }
}