import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        // 명함의 가로 길이 세로 길이를 오름차순으로 정렬한다.
        for(int[] s: sizes){
            Arrays.sort(s);
        }
        
        // 한쪽의 변(가로,세로) List<Integer>에 담기도록 저장하고, 가로 그룹과 세로 그룹에서 가장 큰 값을 곱한 값을 지갑의 크기로 한다.
        List<Integer> width = Arrays.stream(sizes).map(d->d[0]).collect(Collectors.toList());
        List<Integer> height = Arrays.stream(sizes).map(d->d[1]).collect(Collectors.toList());
        int mw = Collections.max(width);
        int mh = Collections.max(height);
        
        return mw*mh;
    }
}