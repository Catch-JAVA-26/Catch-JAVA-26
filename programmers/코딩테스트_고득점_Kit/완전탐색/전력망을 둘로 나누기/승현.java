import java.util.*;

class Solution {
    boolean[][] tree;
    int n;

    public int solution(int n, int[][] wires) {
        this.n = n;
        int answer = n;
        tree = new boolean[n+1][n+1];

        for (int[] wire: wires) {
            int x = wire[0], y = wire[1];
            tree[x][y] = tree[x][y] = true;
        }

        for (int[] wire: wires) {
            int x = wire[0], y = wire[1];
            tree[x][y] = tree[y][x] = false;

            int next = countNode(x);
            int prev = countNode(y); // = (n - next - 2);

            answer = Math.min(answer, Math.abs(next - prev));

            tree[x][y] = tree[x][y] = true;
        }

        return answer;
    }

    public int countNode(int node) {
        int cnt = 0;
        Stack<Integer> nexts = new Stack<>();

        while (findNode(node) != 0) {
            int next = findNode(node);
            nexts.push(next);

            tree[node][next] = tree[next][node] = false;

            cnt += 1 + countNode(next);
        }

        while (!nexts.isEmpty()) {
            int next = nexts.pop();
            tree[node][next] = tree[next][node] = true;
        }

        return cnt;
    }

    public int findNode(int node) {
        int next = 0;
        for (int i=1; i<=n; i++) {
            if (tree[node][i]) {
                next = i;
                break;
            }
            if (tree[i][node]) {
                next = i;
                break;
            }
        }
        return next;
    }

}
