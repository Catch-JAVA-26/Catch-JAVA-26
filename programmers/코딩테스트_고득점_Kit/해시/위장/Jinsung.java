import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int count = 0;
        List<List> box = new ArrayList<>();
        Map<String,Integer> category = new HashMap();
        
        // 각 의상종류에 따라서 List에 담는다.
        for(int loop=0;loop<clothes.length;loop++){
            // 만일 이전에 없던 옷이라면, 새로운 List에 의상을 추가하여 List에 담는다.
            if(category.get(clothes[loop][1]) == null){
                List<String> item = new ArrayList<>();
                item.add(clothes[loop][0]);
                category.put(clothes[loop][1],count++);
                box.add(item);
                
            }else{  // 기존에 있는 옷이라면, List를 꺼내서 의상을 추가.
                box.get(category.get(clothes[loop][1])).add(clothes[loop][0]);
            }
            System.out.println(box);
        }
         
        // 여러개의 리스트의 조합 구하기.
        for(int loop=0;loop<box.size();loop++){
            answer*= box.get(loop).size()+1;
        }
        
        return answer-1;
    }
}