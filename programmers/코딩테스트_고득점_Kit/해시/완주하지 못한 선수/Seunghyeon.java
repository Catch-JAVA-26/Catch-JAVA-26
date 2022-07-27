import java.util.Arrays;

class Seunghyeon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int i;

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (i=0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        if (i == completion.length) {
            answer = participant[completion.length];
        }

        return answer;
    }
}