import java.util.HashMap;

class Solution {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;

        for(int i = 0; i < clothes.length; i++){
            String clothType = clothes[i][1];
            map.put(clothType, map.getOrDefault(clothType, 1) + 1);
        }

        for (String key : map.keySet()) {
            answer *= map.get(key);
        }

        return answer - 1;
    }
}
