import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int start_time = 0;
        int total_time = 0;
        int wating_time = 0;
		int current_time = 0;
        List<int[]> endProcess = new ArrayList<>();
		// 작업의 시간이 짧은것부터 정렬하여, 대기시간을 최소화 할 수 있도록 우선순위 큐를 정렬한다.
		PriorityQueue<int[]> jobList = new PriorityQueue<>(jobs.length,
				(int[] o1,int[] o2)-> o1[1]==o2[1]?o1[0]>o2[0]?1:-1:o1[1]>o2[1]?1:-1
				);
        
        Arrays.sort(jobs,(int[] a1,int[] a2) -> a1[0]==a2[0]?a1[1]>a2[1]?1:-1:a1[0]>a2[0]?1:-1);
        
		// 첫번째 프로세스부터 jobList에 넣는다.
        jobList.add(jobs[0]);
        // 첫번째 작업이 들어온 시간을 저장한다.
        current_time = jobs[0][0];
        
		// 실제 작업시간은 대기시간과는 별개이므로 실제 작업시간만 total에 누적으로 저장하고, answer에는 대기시간+작업시간을 누적으로 저장한다.
		while(!jobList.isEmpty()) {
			
            // 처리해야할 process를 처리 후 endProcess에 넣고, 작업시간(total_time)과 대기시간(working_time)을 포함한 시간을 업데이트한다.
            int[] task = jobList.poll();
            endProcess.add(task);
            
            wating_time = current_time>task[0]?current_time-task[0]:0;
            
            current_time  +=  task[1];
            total_time += wating_time + task[1];
            // System.out.printf("wating:"+wating_time+"\tcurrent:"+current_time+"\ttotal:"+total_time);
            // System.out.println();
            
            // 들어온 작업들의 순서를 다시 재배치
			jobList = rearrangeList(jobList,endProcess,jobs,current_time);
		}
		// 작업의 평균 시간을 구해야하므로, total_time를 작업의 개수로 나눈다.
		// System.out.printf("cur:"+current_time);
        System.out.println();
        return total_time/jobs.length;
    }
    
    public static PriorityQueue<int[]> rearrangeList(PriorityQueue<int[]> jobList,List<int[]> endProcess,int[][] jobs,int total_time){
		
        List<int[]> remainProcess = new ArrayList<int[]>();
        
        // 기존에 존재하는 작업리스트를 모두 제거한다.
        jobList.clear();
        
        // jobs 2중 배열의 작업 중 현재 작업한 시간보다 일찍 들어왔고, 끝난 작업이 아닌 작업들만 다시 jobList에 넣는다.
		for(int[] j : jobs) {
            if(j[0]<=total_time && !endProcess.contains(j))
                jobList.add(j);
            else if(j[0]>total_time && !endProcess.contains(j)){
                remainProcess.add(j);
            }
		}
		
        // 현재시간보다 대기하고 있는 작업이 있다면 미리 땡겨서 실행한다.
        if(jobList.isEmpty() && remainProcess.size()>=1){
            Collections.sort(remainProcess,(int[] o1,int[] o2)-> o1[1]==o2[1]?o1[0]>o2[0]?1:-1:o1[1]>o2[1]?1:-1);
            jobList.add(remainProcess.get(0));
        }
        
		return jobList;
	}
    
}