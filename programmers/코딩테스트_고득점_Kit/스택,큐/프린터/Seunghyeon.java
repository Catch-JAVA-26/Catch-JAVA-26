import java.util.*;

class Seunghyeon {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> q = new LinkedList<>();
        List<Print> l = new ArrayList<>();

        for (int i=0; i<priorities.length; i++) {
            q.offer(new Print(i, priorities[i]));
        }

        while (!q.isEmpty()) {
            Print p = q.poll();
            if (p.isPrinted) continue;
            p.isPrinted = true;
            for (Print print: q) {
                if (p.priority < print.priority) {
                    p.isPrinted = false;
                    q.offer(p);
                    break;
                }
            }
            if (p.isPrinted) {
                l.add(p);
            }
        }

        for (int i=0; i<l.size(); i++) {
            Print p = l.get(i);
            if (p.item == location) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    class Print {
        int item;
        int priority;
        boolean isPrinted = false;

        public Print(int item, int priority) {
            this.item = item;
            this.priority = priority;
        }
    }
}