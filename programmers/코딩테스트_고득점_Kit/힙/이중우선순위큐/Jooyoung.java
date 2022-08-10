import java.util.*;

class Solution {
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        int[] answer = new int[2];

        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String cmd = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if ("I".equals(cmd)) {

            }
            switch (cmd) {
                case "I":
                    minq.offer(value);
                    maxq.offer(value);
                    break;
                case "D":
                    if (minq.size() < 1)
                        break;

                    if (value > 0){
                        int max = maxq.poll();
                        minq.remove(max);
                    } else {
                        int min = minq.poll();
                        maxq.remove(min);
                    }
            }
        }

        if (minq.size() > 0) {
            answer[0] = maxq.poll();
            answer[1] = minq.poll();
        }

        return answer;
    }
}
