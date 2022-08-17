import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static byte[] arr;
    static boolean[] visited;

    public int solution(String numbers) {
        arr = numbers.getBytes();
        visited = new boolean[numbers.length()];
        recursion("", 0);

        return set.size();
    }

    public void recursion(String str, int idx){
        if(isNotBlankStr(str)) {
            int num = Integer.parseInt(str);
            if (isPrime(num)) set.add(num);
        }

        if (idx == arr.length) return;

        for (int i = 0; i < arr.length; i++){
            if(visited[i]) continue;

            visited[i] = true;
            recursion(str + (char) arr[i], idx + 1);
            visited[i] = false;
        }
    }

    public boolean isPrime(int num){
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }

        return true;
    }

    public static boolean isNotBlankStr(String str) {
        return !("".equals(str));
    }
}
