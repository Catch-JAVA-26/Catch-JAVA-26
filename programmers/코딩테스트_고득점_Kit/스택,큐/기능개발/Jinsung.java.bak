import java.util.*;

class Seunghyeon {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<progresses.length; i++) {
            q.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        List<Integer> list = new ArrayList<>();

        int n = q.poll();
        int deployCnt = 1;
        while (!q.isEmpty()) {
            if (q.peek() <= n) {
                deployCnt++;
                q.poll();
            } else {
                list.add(deployCnt);
                deployCnt = 1;
                n = q.poll();
            }
        }
        list.add(deployCnt);

        int i = 0;
        answer = new int[list.size()];
        for (int item: list) {
            answer[i++] = item;
        }

        return answer;
    }
}