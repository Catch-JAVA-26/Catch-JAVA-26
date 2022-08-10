import java.util.*;

class Job {
    int requestTime;
    int workingTime;

    public Job(int requestTime, int workingTime) {
        this.requestTime = requestTime;
        this.workingTime = workingTime;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        LinkedList<Job> waitingList = new LinkedList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(j -> j.workingTime));

        for (int[] job : jobs) {
            waitingList.offer(new Job(job[0], job[1]));
        }

        waitingList.sort(Comparator.comparingInt(j -> j.requestTime));

        int answer = 0, cnt = 0;
        int time = waitingList.peek().requestTime;

        while (jobs.length > cnt) {
            while ((!waitingList.isEmpty()) && (waitingList.peek().requestTime <= time)) {
                pq.offer(waitingList.pollFirst());
            }

            if (!pq.isEmpty()) {
                Job job = pq.poll();
                time += job.workingTime;
                answer += time - job.requestTime;
                cnt++;
            } else {
                time++;
            }
        }

        return answer / cnt;
    }
}
