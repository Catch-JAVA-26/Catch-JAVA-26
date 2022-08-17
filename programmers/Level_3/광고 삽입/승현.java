class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = string2sec(play_time), advSec = string2sec(adv_time);
        int[] runningTime = new int[playSec];

        for (String log: logs) {
            String[] times = log.split("-");
            int start = string2sec(times[0]);
            int end = string2sec(times[1]);
            for (int i=start; i<end; i++) {
                runningTime[i]++;
            }
        }

        long sum = 0, max = 0;
        int startSec = 0;
        for (int i=0; i<advSec; i++) {
            sum += runningTime[i];
        }

        max = sum;
        for (int i=advSec; i<playSec; i++) {
            sum += runningTime[i] - runningTime[i - advSec];
            if (max < sum) {
                max = sum;
                startSec = i - advSec + 1;
            }
        }

        return sec2string(startSec);
    }

    private int string2sec(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 3600
                + Integer.parseInt(times[1]) * 60
                + Integer.parseInt(times[2]);
    }

    private String sec2string(int sec) {
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%02d:", sec / 3600));
        sec %= 3600;
        sb.append(String.format("%02d:", sec / 60));
        sb.append(String.format("%02d", sec % 60));
        return sb.toString();
    }
}