import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        
        for(int loop=0;loop<commands.length;loop++){
            // array의 부분 배열을 subArr에 저장하고 
            int[] subArr = Arrays.copyOfRange(array,commands[loop][0]-1,commands[loop][1]);
            // 부분 배열을 정렬한 후
            Arrays.sort(subArr);
            // k번째 있는 수를 num에 추가한다.
            num.add(subArr[commands[loop][2]-1]);
        }
        
        // 반환할 answer 배열에 num의 값을 저장하여 반환
        int[] answer = new int[num.size()];
        for(int i=0;i<num.size();i++){
            answer[i]=num.get(i);
        }
        
        return answer;
    }
}