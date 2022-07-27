import java.util.Set;
import java.util.HashSet;

class Seunghyeon {
    public int solution(int[] nums) {
        Set<Integer> hs = new HashSet<>();

        for (int num: nums) {
            hs.add(num);
        }

        return Math.min(hs.size(), nums.length/2);
    }
}