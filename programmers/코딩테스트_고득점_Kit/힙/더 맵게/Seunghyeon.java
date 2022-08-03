import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n: scoville) {
            pq.offer(n);
        }

        while (pq.peek() < K && pq.size() > 1) {
            answer++;
            int n = pq.poll();
            int m = pq.poll();
            pq.offer(n + m * 2);
        }

        if (pq.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}