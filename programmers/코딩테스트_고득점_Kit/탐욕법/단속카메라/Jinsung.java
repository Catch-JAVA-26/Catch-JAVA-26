import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = -30000;
        
        // 고속도로를 종료시점이 작은 순서대로 재정렬한다.
        Arrays.sort(routes,(s1,s2) -> s1[1]>s2[1] ? 1 : -1);
        
        // 고속도로를 지나간 차량들을 보면서, 현재 카메라의 위치보다 시작지점이 이후라면 카메라를 설치한다.
        for(int[] r: routes){
            if(camera < r[0]){
                camera = r[1];
                answer++;
            }
        }
        
        return answer;
    }
}