import java.util.*;

class Solution {
    public int[] solution(String[] arguments) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> ascend = new PriorityQueue<>();
        PriorityQueue<Integer> descend = new PriorityQueue<>(Collections.reverseOrder());

        for (String op: arguments) {
            char ch = op.charAt(0);
            int num = Integer.parseInt(op.substring(2));

            if (ch == 'I') {
                ascend.offer(num);
                descend.offer(num);
            } else if (ascend.size() > 0) {
                int deleted = 0;
                deleted = num == -1? ascend.poll(): descend.poll();
                ascend.remove(deleted);
                descend.remove(deleted);
            }
        }

        if (ascend.size() == 1) {
            answer[0] = answer[1] = ascend.poll();
        } else if (ascend.size() > 1) {
            answer[0] = descend.poll(); // max
            answer[1] = ascend.poll(); // min
        }

        return answer;
    }
}