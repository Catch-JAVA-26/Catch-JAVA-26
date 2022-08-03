import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>();
        PriorityQueue<Job> tmp = new PriorityQueue<>();

        for (int[] job: jobs) {
            pq.offer(new Job(job[0], job[1]));
        }


        while (!pq.isEmpty()) {
            boolean isFound = false;
            tmp.clear();
            while (!pq.isEmpty()) {
                Job job = pq.poll();
                tmp.offer(job);
                if (job.requestTime <= time) {
                    answer += time - job.requestTime + job.requiredTime;
                    time += job.requiredTime;
                    tmp.remove(job);
                    isFound = true;
                    break;
                }
            }
            pq.addAll(tmp);
            if (!isFound) {
                time++;
            }
        }

        answer /= jobs.length;

        return answer;
    }

    class Job implements Comparable<Job> {
        int requestTime;
        int requiredTime;

        @Override
        public int compareTo(Job o) {
            return this.requiredTime - o.requiredTime;
        }

        Job(int requestTime, int requiredTime) {
            this.requestTime = requestTime;
            this.requiredTime = requiredTime;
        }
    }
}