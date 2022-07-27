import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        // nums 배열을 순회하면서 hashSet에 값을 넣어 폰켓몬의 종류가 몇개가 있는지 파악한다.
        Set hash = new HashSet();
        for(int i=0;i<nums.length;i++){
            hash.add(nums[i]);
        } 
        // 폰켓몬의 종류를 파악한 후 
        // N/2가 더 크면 폰켓몬의 최대 수를 반환하고
        // 폰켓몬의 최대수가 더 크면 N/2의 값을 반환한다.
        return hash.size() < nums.length/2 ? hash.size() : nums.length/2;
    }
}