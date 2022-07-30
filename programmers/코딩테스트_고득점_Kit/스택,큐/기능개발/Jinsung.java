import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> num = new ArrayList<>();
        int hudleTime = 0;
        int count = 0;
        // progresses와 speeds를 순회하면서, 자신보다 작거나 같은 숫자를 만나면 반영 숫자를 증가 시키고, 큰 숫자를 만나면 작업 리스트에 추가하고 다시 1부터 시작한다.
        for(int loop=0;loop<progresses.length;loop++){
            int workTime = (100 - progresses[loop])/speeds[loop] + (((100 - progresses[loop]) % speeds[loop] == 0) ? 0 : 1);
            if(loop==0){
                hudleTime = workTime;
                count = 1;
            }else{
                // 만일 자신보다 큰 workTime을 만나면 hudleTime을 workTime으로 업데이트하고, 지금까지 쌓아온 count를 num List에 추가한다.
                if(hudleTime<workTime){
                    num.add(count);
                    count=1;
                    hudleTime = workTime;
                }else{
                    count++;
                }
            }
        }
        num.add(count);
        
        // num 리스트의 숫자를 int array로 변환한다.
        int[] result = new int[num.size()];
        for(int i=0;i<num.size();i++){
            result[i] = num.get(i);
        }

        return result;
    }
}