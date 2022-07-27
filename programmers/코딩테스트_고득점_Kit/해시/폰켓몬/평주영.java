package 코딩테스트_고득점_Kit.해시.폰켓몬;
import java.util.*;
import java.util.stream.Collectors;

class 평주영 {
    public int solution(int[] nums) {
        int size = nums.length / 2;
        List<Integer> poketmons = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());

        return Math.min(poketmons.size(), size);
    }
}