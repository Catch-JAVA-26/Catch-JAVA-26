import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] strNumbers = new String[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            strNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strNumbers, (o1, o2) -> {
            int min = Math.min(o1.length(), o2.length());
            int max = Math.max(o1.length(), o2.length());

            for (int i=0; i<min; i++) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    return o2.charAt(i) - o1.charAt(i);
                }
            }

            if (o1.length() > o2.length()) {
                for (int i=0; i<min; i++) {
                    for (int j=min; j<max; j++) {
                        if (o1.charAt(j) != o2.charAt(i)) {
                            return o2.charAt(i) - o1.charAt(j);
                        }
                    }
                }
            } else if (o1.length() < o2.length()) {
                for (int i=0; i<min; i++) {
                    for (int j=min; j<max; j++) {
                        if (o1.charAt(i) != o2.charAt(j)) {
                            return o2.charAt(j) - o1.charAt(i);
                        }
                    }
                }
            }

            return 0;
        });

        if (strNumbers[0].equals("0")) {
            answer.append("0");
        } else {
            for (String str: strNumbers) {
                answer.append(str);
            }
        }

        return answer.toString();
    }
}