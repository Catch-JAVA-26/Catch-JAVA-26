import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = {};
        
        // 카펫의 전체 넓이는 brown + yellow이므로 area에 brown과 yellow의 합을 저장한다.
        int area = brown + yellow;
        
        // area크기부터 1까지 모든 수를 나눠보면서 area의 가로 세로 길이의 모든 조합을 다 구한다.
        ArrayList<int[]> combinationArea = new ArrayList<>();
        for(int i=area;i>0;i--){
            if(area%i==0){
                int[] candidate = {i,area/i};
                combinationArea.add(candidate);
            }
        }
        
        // yellow의 넓이는 전체 가로 세로의 길이보다 2만큼 작고,
        // brown의 넓이는 전체 카벳의 가로*세로에서 yellow의 넓이를 뺀 크기이므로
        // 위 조건을 만족하는 가로,세로 조합이 있다면 바로 반환한다.
        for(int[] c : combinationArea){
            if(c[0]>=2 && c[1]>=2){
                if( (yellow == (c[0]-2) * (c[1]-2)) && (brown == c[0]*c[1] -yellow ) ){                
                    answer = c;
                    break;
                }
            }
        }
        
        return answer;
    }
}
