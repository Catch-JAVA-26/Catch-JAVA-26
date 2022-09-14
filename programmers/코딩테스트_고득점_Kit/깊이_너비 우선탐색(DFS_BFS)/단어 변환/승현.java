import java.util.*;

class Solution {
    int answer;
    boolean[] visit;
    public int solution(String begin, String target, String[] words) {
        answer = words.length + 1;
        visit = new boolean[words.length];

        dfs(words, begin, target, 0);

        return answer == words.length + 1 ? 0: answer;
    }

    public void dfs(String[] words, String word, String target, int depth) {
        if (target.equals(word)) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i=0; i<words.length; i++) {
            if (!visit[i] && isSameWithoutOne(word, words[i])) {
                visit[i] = true;
                dfs(words, words[i], target, depth + 1);
                visit[i] = false;
            }
        }
    }

    private boolean isSameWithoutOne(String a, String b) {
        int cnt = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }
}