import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
		PriorityQueue<Integer> numArray = new PriorityQueue<>();
		// scoville 안에 있는 숫자들을 우선순위 큐에 모두 집어 넣는다.
        for(int s : scoville) {
			numArray.add(s);
		}
		
        // 우선순위 큐의 사이즈가 2보다 크거나 같고 가장 앞에 있는 숫자가 K보다 작을경우 가장 맵지 않은 두 음식을 섞는다.
        // 우선순위 큐는 추가할때 가장 작은 값이 앞으로 가도록 정렬되므로, 추가적은 숫자 재배치를 우선순위큐 안에서 실행된다.
		while(numArray.size()>=2&&numArray.peek()<K) {
			int a = numArray.poll();
			int b = numArray.poll();
			int scIndex = a + (b*2);
			numArray.add(scIndex);
			answer++;
		}
		
		return numArray.peek()<K?-1:answer;
    }
}