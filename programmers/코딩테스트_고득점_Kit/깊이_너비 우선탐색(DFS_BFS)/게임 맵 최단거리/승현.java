import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        int[] dirX = new int[]{1, -1, 0, 0};
        int[] dirY = new int[]{0, 0, 1, -1};

        int answer = n * m + 1;
        int[][] visit = new int[n][m];

        for (int[] v: visit) {
            Arrays.fill(v, -1);
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        visit[0][0] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x, y = node.y;

            if (x == m-1 && y == n-1) {
                answer = Math.min(answer, visit[y][x]);
                continue;
            }

            for (int i=0; i<4; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];

                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }

                if (visit[newY][newX] == -1 && maps[newY][newX] == 1) {
                    q.offer(new Node(newX, newY));
                    visit[newY][newX] = visit[y][x] + 1;
                }
            }
        }

        return answer == n * m + 1 ? -1 : answer;
    }

    class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}