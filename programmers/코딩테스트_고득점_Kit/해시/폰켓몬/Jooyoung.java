import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] nums) {
        int size = nums.length / 2;
        List<Integer> poketmons = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());

        return Math.min(poketmons.size(), size);
    }
}
