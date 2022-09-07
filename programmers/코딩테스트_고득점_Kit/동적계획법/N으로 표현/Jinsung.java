import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        int start=0,end=0;
        int getValue = 0;
        int cycle = 0;
        int result = 0;
        int[] digit = {1,11,111,1111,11111,111111,1111111,11111111,111111111,1111111111};
        ArrayList<Integer> box = new ArrayList<>();
        
        start=box.size(); 
        box.add(N);
        end = box.size();
        
		// 만일 N이 number와 같다면 1 반환
        if(N == number)
            return 1;
        
        // 한번의 cycle이 돌았으므로 1 증가
		cycle+=1;
		
		// 8이상이면 -1이므로 7보다 작을때까지만 순회
        while(cycle<7){
            for(int i=start;i<end;i++){
                getValue = box.get(i);
                // 0보다 작은 값은 불필요하므로
				if(getValue > 0){
                    // 더하기 연산 결과 추가
					box.add(getValue+N);
                    // 빼기 연산 결과 추가(단 가져온 값과 N 중 누가 더 클지 모르므로 순서를 바꿔서 연산) 
					result = getValue-N; 
                    if(result>0){
                        box.add(result);    
                    }
                    result = N-getValue; 
                    if(result>0){
                        box.add(result);    
                    }
					// 곱하기 연한 추가
                    box.add(getValue*N);
                    // 나누기 연산 결과 추가(단 가져온 값과 N 중 누가 더 클지 모르므로 순서를 바꿔서 연산) 
					result = getValue/N; 
                    if(result>0){
                        box.add(result);    
                    }
                    result = N/getValue; 
                    if(result>0){
                        box.add(result);    
                    }
                }
            }
			// start를 이전의 끝으로 업데이트하고, 현재 사이클에 해당하는 값에 위치하는 1의 값에 N을 곱하여 box에 추가
            start = end;
            getValue = digit[cycle]*N;
            box.add(getValue);
			// end는 현재까지 추가된 box의 사이즈로 업데이트
            end = box.size();
			// 시작점부터 끝까지 number와 동일한 값이 존재한다면 cycle + 1을 반환.
            for(int loop=start;loop<end;loop++){
                if(box.get(loop) == number){
                    return cycle+1;
                }
            }
            cycle+=1;
        }
        
        return -1;
    }
}