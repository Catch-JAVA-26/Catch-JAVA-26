import java.util.*;

class Solution {
    String[] chars = {"A", "E", "I", "O", "U"};
    StringBuilder sb = new StringBuilder("");
    int answer = 0;

    public int solution(String word) {
        loop:
        for (int i=0; i<5; i++) {
            if (isEquals(word, i, 0)) {
                break loop;
            }
            for (int j=0; j<5; j++) {
                if (isEquals(word, j, 1)) {
                    break loop;
                }
                for (int k=0; k<5; k++) {
                    if (isEquals(word, k, 2)) {
                        break loop;
                    }
                    for (int l=0; l<5; l++) {
                        if (isEquals(word, l, 3)) {
                            break loop;
                        }
                        for (int m=0; m<5; m++) {
                            if (isEquals(word, m, 4)) {
                                break loop;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    public boolean isEquals(String word, int index, int depth) {
        answer++;
        sb.delete(depth, sb.length());
        sb.append(chars[index]);

        return word.equals(sb.toString())? true: false;
    }
}